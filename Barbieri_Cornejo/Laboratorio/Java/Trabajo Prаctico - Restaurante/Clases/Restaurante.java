import java.util.ArrayList;

public class Restaurante{

    //Elementos
    private ArrayList<Mesa> Lista_Mesa;
    private ArrayList<Plato> Lista_Platos;
    private String Cocinero;

    //Constructores
    public Restaurante(){
        Cocinero = "Matias";
        Lista_Mesa = new ArrayList<Mesa>();
        Lista_Platos = new ArrayList<Plato>();
    }

    public Restaurante(String cooker){
        Cocinero = cooker;
        Lista_Mesa = new ArrayList<Mesa>();
        Lista_Platos = new ArrayList<Plato>();
    }

    //Setters
    public void setCocinero(String cooker) {
        this.Cocinero = cooker;
    }

    //Getters
    public String getCocinero(){
        return this.Cocinero;
    }

    //Metodos
    public void agregarMesa(Mesa nueva){
        this.Lista_Mesa.add(nueva);
    }

    public void agregarPlatoAPreparar(Plato nuevo){
        this.Lista_Platos.add(nuevo);
    }

    public Mesa getMesa(int pos){
        return this.Lista_Mesa.get(pos);
    }

    public Plato getPlato(int pos){
        return this.Lista_Platos.get(pos);
    }

    public boolean checkEmpty(){
        boolean vacio;
        vacio = this.Lista_Platos.isEmpty();
        return vacio;
    }

    public void agregarPedidoAMesa(Plato x){
        int posicion = x.getNumeroDeMesa() - 1;
        this.lista_Mesa.add(posicion);
    }

    public void Numero_Mesa_Por_Tipo(){ //chequear si esta vacio Lista_Platos ---> for
        if(checkEmpty()==false){
            for(int i=0;i<this.Lista_Platos.size();i++){
                System.out.println("Plato :"+this.Lista_Platos.get(i).getNombre()+" ; Numero de Mesa :"+this.Lista_Platos.get(i).getNumeroDeMesa());
            }
        }
    }

    public void Numero_Pedido_Por_Tipo(){ // chequear si esta vacio Lista_Platos ---> for
        if(checkEmpty()==false){
            for(int i=0;i<this.Lista_Platos.size();i++){
                System.out.println("Plato :"+this.Lista_Platos.get(i).getNombre()+" ; Numero de Mesa :"+this.Lista_Platos.get(i).getNumeroDePedido());
            }
        }
    }

    public void Cantidad_Platos_Por_Tipo(){  // chequear si esta vacio Lista_Platos ---> for
        if(checkEmpty()==false){
            for(int i=0;i<this.Lista_Platos.size();i++){
                System.out.println("Plato :"+this.Lista_Platos.get(i).getNombre()+" ; Numero de Mesa :"+this.Lista_Platos.get(i).getCantidad());
            }
        }
    }

    public String Plato_Mas_Pedido(){ //   ----> getPlato()
        String Mas_Pedido;
        int[] contador = new int[this.Lista_Platos.size()];
        int mayor = 0;

        for(int i=0; i<this.Lista_Platos.size();i++){
            for(int j=0; j<this.Lista_Platos.size();j++){
                if(this.Lista_Platos.get(i).getNombre() == this.Lista_Platos.get(j).getNombre()){
                    contador[i]++;
                }
            }
        }
        for(int i=0;i<contador.length;i++){
            if(mayor<contador[i]){
                mayor = contador[i];
            }
        }
        Mas_Pedido = this.Lista_Platos.get(mayor).getNombre();
        return Mas_Pedido;
    }

    public String Plato_Menos_Pedido(){ // ----> getPlato()
        String Menos_Pedido;
        int[] contador = new int[this.Lista_Platos.size()];
        int menor = 0;

        for(int i=0; i<this.Lista_Platos.size();i++){
            for(int j=0; j<this.Lista_Platos.size();j++){
                if(this.Lista_Platos.get(i).getNombre() != this.Lista_Platos.get(j).getNombre()){
                    contador[i]++;
                }
            }
        }
        for(int i=0;i<contador.length;i++){
            if(menor<contador[i]){
                menor = contador[i];
            }
        }
        Menos_Pedido = this.Lista_Platos.get(menor).getNombre();
        return Menos_Pedido;
    }


}
