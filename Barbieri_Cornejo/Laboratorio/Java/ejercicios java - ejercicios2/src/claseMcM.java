public class MinComMult {

    //Atributos 

    private int numero1:
    private int numero2;
    private int min;
    private int mcm;

    //Constructores

    public McM(int n1,int n2,int minimo,int multiplo){
        numero1=n1;
        numero2=n2;
        min=minimo;
        mcm=multiplo;

    }

    //getters

        public int getNumero1(){
            return this.numero1;
        }

        public int getNumero2(){
            return this.numero2;
        }

        public int getMin(){
            return this.min;
        }

        public int getMcm(){
            return this.mcm;
        }

        //Setters 

        public void setNumero1(int n1){
        this.numero1 = n1;
        }

        public void setNumero2(int n2){
            this.numero2 = n2;
        }

        public void setMin(int minimo){
            this.min =minimo;
        }

        public void setMcm(int multiplo){
            this.mcm =multiplo;
        }

        //Metodos


        public int mathmin(int num1,int num2){
            int mathmin=Math.min(num1,num2);
            return mathmin;
        } 

        public int mCm(){

             for (int i=1; i<=min; i++) {

            if (num1%i==0 && num2%i==0) {

                int mcd = i;
                mcm = (num1*num2)/mcd;
            }
            return mcm;
        }}


    }
