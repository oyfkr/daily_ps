package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class find_number {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
        for(int i = 0; i<n;i++){
            int tmp = scan.nextInt();
            a.add(tmp);
        }
        Collections.sort(a);
        int m = scan.nextInt();
        for(int i = 0; i<m;i++){
            int tmp = scan.nextInt();
            int left = 0;
            int right = a.size()-1;
            boolean flag = false;
            while(left <= right){
                int mid = (left+right)/2;
                int midValue = a.get(mid);
                if(midValue > tmp){
                    right = mid-1;
                }else if(midValue < tmp){
                    left = mid+1;
                }else{
                    flag = true;
                    System.out.println(1);
                    break;
                }
            }
            if(!flag){
                System.out.println(0);
            }
        }
    }
}
