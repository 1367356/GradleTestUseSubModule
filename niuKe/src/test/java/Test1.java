import java.util.Scanner;

public class Test1 {

    public static void main(String[] args){
        String s = "abc";
        System.out.println(s.charAt(0));

        Scanner scanner = new Scanner(System.in);

        String s1=scanner.nextLine().toString();
        System.out.println(s1);
        char x='a';

        String userData=scanner.nextLine().toString();
        String[] userArr=userData.split(" ");
        int start=Integer.parseInt(userArr[0]);
        int end=Integer.parseInt(userArr[1]);

        System.out.println(end);
    }
}
