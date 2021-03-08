package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class num_sort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i<n;i++){
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);

        for(int a : arr){
            System.out.println(a);
        }
    }
}
