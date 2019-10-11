#include "ejercicios.h"
#include <vector>

/*

 Comando para producir el ejecutable:

 g++ -o nombreDeEjecutable ejercicios.h ejercicios.cpp main.cpp

 Comando para ejecutarlo:

 ./nombreDelEjecutable

*/


int main(void){

	vector<int> unVector;

	unVector.push_back(2);
	unVector.push_back(7);
	unVector.push_back(6);
	unVector.push_back(14);
	unVector.push_back(21);
	unVector.push_back(30);

	printf("TEST elmenorElemento. Caso nombreDeCaso.");
	int ValorEsperado = 2;
	int ValorFuncion = elMenorElemento(unVector);
	if (ValorEsperado == ValorFuncion) {
		printf("Pasó el test\n");
	}
	else {
		printf("No pasó el test\n");
	};

	printf("TEST tieneDosElementosPares. Caso nombreDeCaso.");
	bool Esperado = true;
	bool Funcion = tieneDosElementosPares(unVector);
	if (Esperado == Funcion) {
		printf("Pasó el test\n");
	}
	else {
		printf("No pasó el test\n");
	};

	printf("TEST sumaDeLosDosElementosMasChicos. Caso nombreDeCaso.");
	int a = 8;
	int b = sumaDeLosDosElementosMasChicos(unVector);
	if (a == b) {
		printf("Pasó el test\n");
	}
	else {
		printf("No pasó el test\n");
	};

	printf("TEST mostrarVector. Caso nombreDeCaso.");
	string value = ("276142130");
	string function = mostrarVector(unVector);
	if (value == function) {
		printf("Pasó el test\n");
	}
	else {
		printf("No pasó el test\n");
	};

}

