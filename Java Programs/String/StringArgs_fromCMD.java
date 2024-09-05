public class StringArgs_fromCMD{
	private static int  cnt = 0;
	public static void main(String[] args){
		for(String str:args){System.out.println("Cmd Args String no."+(++cnt)+": "+str);}
	}
}

// $ java test1 Hi this is the string i entered from command line
