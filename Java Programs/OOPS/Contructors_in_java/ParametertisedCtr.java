public class ParametertisedCtr {

    ParametertisedCtr(int var){System.out.println("The passed value in parameterised constructor is: "+var);}

    public static void main(String[] args) {
        ParametertisedCtr pmctr = new ParametertisedCtr(8);
    }
}
