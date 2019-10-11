import java.util.ArrayList;
import java.util.Stack;

public class Calculadora{

    //Atributos    
    private Programa program;
    private Stack<Integer> pila;
    private ArrayList<Variable> memoria;

    //Constructores
    public Calculadora(){
        program = new Programa();
        pila = new Stack<Integer>();
        memoria = new ArrayList<Variable>();
    }

    public Calculadora(Programa x){
        program = x;
        pila = new Stack<Integer>();
        memoria = new ArrayList<Variable>();
    }

    //Setters
    public void setProgram(Programa x){
        this.program = x;
    }

    //Getters
    public Programa getProgram(){
        return this.program;
    }

    //Metodos

    public void ADD(){
        int valor = 0;
        int resultado = 0;
        if(this.pila.size()>1){
            valor = this.pila.pop();
            resultado = resultado + valor;
            valor = this.pila.pop();
            resultado = resultado + valor;
            this.pila.push(resultado);
        }
    }

    public void SUB(){
        int valor = 0;
        int resultado = 0;
        if(this.pila.size()>1){
            valor = this.pila.pop();
            resultado = resultado - valor;
            valor = this.pila.pop();
            resultado = resultado - valor;
            this.pila.push(resultado);
        }
    }

    public void MUL(){
        int valor = 0;
        int resultado = 0;
        if(this.pila.size()>1){
            valor = this.pila.pop();
            resultado = resultado * valor;
            valor = this.pila.pop();
            resultado = resultado * valor;
            this.pila.push(resultado);
        }
    }

    public void WRITE(String x){
        int valor = 0;
        valor = this.pila.pop();
        for(int i=0; i<this.memoria.size();i++){
            if(this.memoria.get(i).getNombre() == x){
                this.memoria.get(i).setValor(valor);
            }
        }
    }

    public void PUSH(String x){
        int valor = 0;
        for(int i=0; i<this.memoria.size();i++){
            if(this.memoria.get(i).getNombre() == x){
                valor = this.memoria.get(i).getValor();
                this.pila.push(valor);
            }
        }
    }

    public void READ(String x){
        int valor = 0;
        for(int i=0; i<this.memoria.size();i++){
            if(this.memoria.get(i).getNombre() == x){
                valor = this.memoria.get(i).getValor();
                this.pila.push(valor);
            }
        }
    }

    public void ejecutar(String name){
        for(int i=0; i<this.program.getListRutinas().size(); i++){ // recorre el largo del listado de rutinas del programa cargado
            if(this.program.getListRutinas().get(i).getNombre() == name){ // // ejecuta la rutina ingresada entre el listado de rutinas
                for(int j=0; j<this.program.getListRutinas().get(i).getList_Insts().size(); j++){
                    switch(this.program.getListRutinas().get(i).getList_Insts().get(j).getNombreInstruccion()){
                        case "ADD":
                            this.ADD();
                        break;
                        case "SUB":
                            this.SUB();
                        break;
                        case "MUL":
                            this.MUL();
                        break;
                        case "PUSH":
                            this.PUSH(this.program.getListRutinas().get(i).getList_Insts().get(j).getNombreVariable());
                        break;
                        case "WRITE":
                            this.WRITE(this.program.getListRutinas().get(i).getList_Insts().get(j).getNombreVariable());
                        break;
                        case "READ":
                            this.READ(this.program.getListRutinas().get(i).getList_Insts().get(j).getNombreVariable());
                        break;
                    }
                }
            }
        }
    }

}