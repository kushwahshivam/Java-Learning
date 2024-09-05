public class StaticMethod_vs_NonStaticMethod{
    public void myPublicMethod(){System.out.println("This is from public method");} 
    public static void myStaticMethod(){System.out.println("This is from static method");} 
    public static void main(String[] args) {
        testStaticMethod testObjForNonStaticMethod =  new testStaticMethod();
        testObjForNonStaticMethod.myPublicMethod();
        myStaticMethod();
    }
}
