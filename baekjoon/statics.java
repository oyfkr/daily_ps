package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class statics {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] num = new double[n];
        for(int i = 0; i<n;i++){
            num[i] = sc.nextDouble();
        }
        // 산술평균
        double sum = 0;
        for(double d : num) sum+=d;
        System.out.println((int)Math.round(sum/n));

        //중앙값
        Arrays.sort(num);
        System.out.println((int)num[n/2]);

        //최빈값
        int[] cnt = new int[8001];
        for(double d : num) cnt[(int)d+4000]++;
        int maxCnt = 0;
        int maxIndex = 0;
        for(int i = 0;i<8001;i++){
            if(cnt[i] > maxCnt) maxCnt = cnt[i];
        }
        boolean twice = false;

        for(int i = 0; i<8001;i++){
            if(cnt[i] == maxCnt){
                if(twice){
                    maxIndex = i-4000;
                    break;
                }
                maxIndex = i-4000;
                twice = true;
            }
        }

        System.out.println(maxIndex);

        // 범위위
        System.out.println((int)(num[n-1] - num[0]));
    }
}
