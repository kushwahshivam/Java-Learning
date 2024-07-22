package String;

public class stringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("I like programming");
        sb.append(" and coffee");
        System.out.println(sb);
        
        sb.insert(18,", gamming");
        System.out.println(sb);
        
        sb.replace(2,6,"love");
        System.out.println(sb);
        
        
        //delete
        sb.delete(7,20);
        System.out.println(sb);
        
        //converting a stringbuilder instance to string
        String str = sb.toString();
        System.out.println(str);
    }
}
