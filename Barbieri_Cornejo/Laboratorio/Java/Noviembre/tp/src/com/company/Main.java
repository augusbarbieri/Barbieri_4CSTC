package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    }

    private ArrayList<Mascota> mascotas;

    public static void agregarMascota(Mascota animal, ArrayList<Mascota> mascotas){

        scan = new Scanner(System.in);
        System.out.println("Ingrese tipo de animal 1-Perro;2-Gato;3-Pajaro;4-Pez");
        aux = scan.nextInt();
        System.out.println("Ingrese nombre");
        aux2 = scan.nextInt();

        switch(scan) {
            case 1:
                for (int i=0;i<mascotas.size();i++){
                    if(aux2==mascotass.get(i).getNombre()){
                        System.out.println("Nombre no disponible");
                    }
                    else{
                        mascotas.add(aux2=new Perro);
                    }
                }

                break;
            case 2:
                for (int i=0;i<mascotas.size();i++){
                    if(aux2==mascotass.get(i).getNombre()){
                        System.out.println("Nombre no disponible");
                    }
                    else{
                        mascotas.add(aux2=new Gato);
                    }
                }

                break;
            case 3:
                for (int i=0;i<mascotas.size();i++){
                    if(aux2==mascotass.get(i).getNombre()){
                        System.out.println("Nombre no disponible");
                    }
                    else{
                        mascotas.add(aux2=new Pajaro);
                    }
                }

                break;
            case 4:
                for (int i=0;i<mascotas.size();i++){
                    if(aux2==mascotass.get(i).getNombre()){
                        System.out.println("Nombre no disponible");
                    }
                    else{
                        mascotas.add(aux2=new Pez);
                    }
                }

                break;
        }

    }



    public void eliminarmascota(String matar){
        for(int i=0;i<mascotas.size();i++){
            if(matar==mascotas.get(i).getNombre()){
                mascotas.remove(i);
            }
        }
    }

    public void modicarMascota(){

    }



}
