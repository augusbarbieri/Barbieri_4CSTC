public class Factorial {

    // Atributos

    private int a;

    // Constructores
   
    public Factorial() {
      this.a = 8;
      } 
     
    public Factorial(int a) {
        this.a = a;
    }

    // Setter

    public void setFactorial(int a) {
        this.a = a;
    }

    // Getter

    public int getFactorial() {
        return this.a;
    }

    // Metodos

    public int hagoFactorial(){
        int factorial = 1;
        int a = this.a;
        if (a == 0){
            return 1;
        }
        else{
            while (a != 0) {
                factorial = factorial *a ;
                a--;
            }
        }
            return factorial;
    } 
}
