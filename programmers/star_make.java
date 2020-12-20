package programmers;

import java.util.Scanner;

public class star_make {
    public static void main(String args[]){
        Scanner sc =new Scanner(System.in);
        int a =sc.nextInt();
        int b = sc.nextInt();
        String star ="";
        for(int i = 0; i<b; i++){
            for(int j = 0; j<a; j++){
                star +="*";
            }
            star +="\n";
        }
        System.out.println(star);
    }
}
