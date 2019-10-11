#include "ejercicios.h"
#include <vector>


int dobleDeEntero(int numero){

	int doble = 2 * numero;

	return doble;
}


bool SeasonIguales(int numero1, int numero2){

    if (numero1==numero2){
        return true;
    }
    else{
        return false;
    }

}

int tripleDeEntero(int numero){

    numero=numero*3;
    return numero;

}

int sumaDeDosEnteros(int numero1, int numero2){

    numero1=numero1+numero2;
    return numero1;


}

bool esPar(int numero){

    numero=numero%2;
    if (numero==0){

       return true;

    }
    else{

    return false;

    }

}

bool esImpar(int numero){

    numero=numero%2;
    if (numero==0){

        return false;

    }
    else{

        return true;

    }

}

bool esMultiploDeOcho(int numero){

    if (numero%8==0){

        return true;

    }
    else{

        return false;

    }

}

int cantidadDeElementos(vector<int> unVector){

    return unVector.size();

}

int sumaDeElementos(vector<int> unVector){

    int suma=0;
    for (int i=0; i<unVector.size(); i++){

       suma=unVector[i]+suma;

    }
    return suma;

}

int promedioDeElementos(vector<int> unVector){

    float suma=0;

    for (int i=0; i<unVector.size(); i++){

       suma=unVector[i]+suma;

    }

    suma = suma/unVector.size();

    return suma;

}

vector<int> triplicoElementos(vector<int> unVector){

    for (int i=0; i<unVector.size() ; i++){

        unVector[i]=unVector[i]*3;

    }

    return unVector;

}

// HACER TEST
int elMenorElemento(vector<int> unVector){

        int menor=0;

        for (int i=0; i<unVector.size() ; i++){

            if (menor>unVector[i]){

                menor=unVector[i];

            }

        }
        return menor;

}

int elMayorElemento(vector<int> unVector){

    int mayor=0;

        for (int i=0; i<unVector.size() ; i++){

            if (mayor<unVector[i]){

                mayor=unVector[i];

            }

        }

    return mayor;
}

vector<int> elementosConIndicePar(vector<int> unVector){

        vector<int> nuevo;

        for(int i=0; i<unVector.size(); i++)
        {
            if( i%2 == 0 or i== 0)
            {
                nuevo[i] = i;
            }
        }
        return nuevo;

}


vector<int> elementosConIndiceImpar(vector<int> unVector){

        vector<int> nuevo;

        for(int i=0; i<unVector.size(); i++){
            if( i%2 != 0 or i != 0){
                nuevo[i] = i;
            }
        }

    return nuevo;

}


vector<int> elementosMayoresQue8(vector<int> unVector){

    vector<int> nuevo;

    for ( int i=0 ; i<unVector.size() ; i++){

        if (unVector[i]>8){

            nuevo[i] = unVector[i];

        }
    }

    return nuevo;

}


vector<int> elementosMayoresQueNumero(vector<int> unVector, int numero){

    vector<int> nuevo;

    for ( int i=0; i<unVector.size(); i++){

        if (unVector[i]>numero){

            nuevo[i] = unVector[i];

        }

    }

    return nuevo;

}


bool todosSusElementosSonIguales(vector<int> unVector){

    for ( int i=0 ; i<unVector.size()-1 ; i++){

        if (unVector[i] != unVector[i+1]){

            return false;

        }
    }
    return true;

}

bool sonVectoresIguales(vector<int> vectorUno, vector<int> vectorDos){

    if (vectorUno.size() != vectorDos.size() ){
        return false;
    }

    for (int i=0; i<vectorUno.size() ; i++){

        if (vectorUno[i]!=vectorDos[i]){

            return false;

        }

    }
    return true;

}

// HACER TEST
bool tieneDosElementosPares(vector<int> unVector){

    int pares = 0;

    for( int i=0 ; i<unVector.size() ; i++){

        while(pares<3){

            if(unVector[i]%2 == 0 or unVector[i] == 0)
            {
                pares++;
            }
        }
    }

    if( pares == 2){
        return true;
    }
    else{
        return false;
    }

}

// HACER TEST
int sumaDeLosDosElementosMasChicos(vector<int> unVector){

    int menores = 0;
    int suma = 0;
    int menor = 0;

    for( int i=0 ; i<unVector.size() ; i++){

         while(menores<3){

            if(menor > unVector[i]){

                menor = unVector[i];
                suma = suma + menor;
				menores++;
            }
         }
    }

    return suma;

}

vector<vector<int> > llenarDeCeros(vector<vector<int> > unaMatriz){

    for (int i=0 ; i<unaMatriz.size() ; i++){

        for(int j=0 ; j<unaMatriz[i].size() ; j++){

            unaMatriz[i][j]=0;
        }

    }

    return unaMatriz;
}

// HACER TEST
void mostrarVector(vector<int> unVector){

    for( int i=0 ; i<unVector.size() ; i++ ){

        cout<<unVector[i];

    }
}