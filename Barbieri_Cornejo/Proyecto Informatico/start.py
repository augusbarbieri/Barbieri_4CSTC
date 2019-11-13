#!/usr/bin/python
import RPi.GPIO as gpio
import time
from threading import Thread

tiempo = 0

def detectAutosNum(sensores, lleno):
    totalAutos = 0
    if lleno[0] and gpio.input(sensores[0]): totalAutos += 1
    if lleno[1] and gpio.input(sensores[1]): totalAutos -= 1
    return totalAutos

def detectAutos(sensores):
    return [not gpio.input(sensores[0]), not gpio.input(sensores[1])]

def semVerde(semaforo):
    gpio.output(semaforo[0], gpio.LOW)
    gpio.output(semaforo[1], gpio.HIGH)
    time.sleep(2)
    gpio.output(semaforo[1], gpio.LOW)
    gpio.output(semaforo[2], gpio.HIGH)
    tiempo = time.time()

def semRojo(semaforo, otro):
    gpio.output(semaforo[2], gpio.LOW)
    gpio.output(semaforo[1], gpio.HIGH)
    time.sleep(2.5)
    gpio.output(semaforo[1], gpio.LOW)
    gpio.output(semaforo[0], gpio.HIGH)
    semVerde(otro)

if __name__ == "__main__":   
    gpio.setmode(gpio.BCM)
    calle1_sensores = [18,17] # el primero numero es el de la entrada y el segundo es de la salida
    calle2_semaforo = [7,22,8] # rojo, amarillo, verde
    calle2_sensores = [9,25]
    calle1_semaforo = [24,27,23]

    for x in range(0,2):
        gpio.setup(calle1_sensores[x], gpio.IN, pull_up_down = gpio.PUD_UP)
        gpio.setup(calle2_sensores[x], gpio.IN, pull_up_down = gpio.PUD_UP)
    for x in range(0,3):
        gpio.setup(calle1_semaforo[x], gpio.OUT)
        gpio.output(calle1_semaforo[x], gpio.LOW)
        gpio.setup(calle2_semaforo[x], gpio.OUT)
        gpio.output(calle2_semaforo[x], gpio.LOW)

    smart = True
    semTiempo = 70
    calle1_senLlenos = [False, False]
    calle1_autos = 0
    calle1_lleno = 0
    calle2_senLlenos = [False, False]
    calle2_autos = 0
    calle2_lleno = 0

    gpio.output(calle1_semaforo[0], gpio.HIGH)
    gpio.output(calle2_semaforo[2], gpio.HIGH)
    tiempo = time.time()
    try:
        while True:
            if smart:
                calle1_autos += detectAutosNum(calle1_sensores, calle1_senLlenos)
                calle2_autos += detectAutosNum(calle2_sensores, calle2_senLlenos)
                calle1_autos = 0 if calle1_autos < 0 else calle1_autos
                calle2_autos = 0 if calle2_autos < 0 else calle2_autos
                calle1_senLlenos = detectAutos(calle1_sensores)
                calle2_senLlenos = detectAutos(calle2_sensores)
                if not gpio.input(calle1_sensores[0]):
                    if calle1_lleno == 0:
                        calle1_lleno = time.time()
                    elif gpio.input(calle1_semaforo[0]) and calle1_autos > calle2_autos and (time.time() - tiempo) >= 20 and (calle2_lleno == 0 or calle1_lleno < calle2_lleno):
                        Thread(target=semRojo, args=(calle2_semaforo,calle1_semaforo,)).start()
                        tiempo = time.time()
                        continue
                elif calle1_lleno != 0:
                    calle1_lleno = 0
                if not gpio.input(calle2_sensores[0]):
                    if calle2_lleno == 0:
                        calle2_lleno  = time.time()
                    elif gpio.input(calle2_semaforo[0]) and calle2_autos > calle1_autos and (time.time() - tiempo) >= 20 and (calle1_lleno == 0 or calle2_lleno < calle1_lleno):
                        Thread(target=semRojo, args=(calle1_semaforo,calle2_semaforo,)).start()
                        tiempo = time.time()
                        continue
                elif calle2_lleno != 0:
                    calle2_lleno = 0
            if (time.time() - tiempo) >= semTiempo:
                if gpio.input(calle1_semaforo[0]):
                    Thread(target=semRojo, args=(calle2_semaforo,calle1_semaforo,)).start()
                else:
                    Thread(target=semRojo, args=(calle1_semaforo,calle2_semaforo,)).start()
                tiempo = time.time()
            print("tiempo: " + str(tiempo) + "\n1Autos: " + str(calle1_autos) + "\n2Autos: " + str(calle2_autos) + "\n1Lleno " + str(calle1_lleno) + "\n2Lleno " + str(calle2_lleno))
    except KeyboardInterrupt:
        gpio.cleanup()
        pass
