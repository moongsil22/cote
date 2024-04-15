import java.util.Scanner;
import java.util.stream.IntStream;

public class 직사각형별찍기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        String star="";
        for(int i=1; i<=b; i++){
            for(int j=1; j<=a; j++){
                star += "*";
            }
            star += "\n";
            
        }
        
        
        System.out.println(star);
    } 

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        IntStream.range(0, a).forEach(s -> sb.append("*"));
        IntStream.range(0, b).forEach(s -> System.out.println(sb.toString()));
    }    

 

}