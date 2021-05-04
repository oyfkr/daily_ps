package baekjoon;

import java.io.*;
import java.util.*;

public class num_card2 {
    static int[] arr1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        
        arr1 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<arr1.length;i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr1);
        
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i<m;i++){
            int num = Integer.parseInt(st.nextToken());
            bw.append((upper_bound(num))-(lower_bound(num))+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static int lower_bound(int num) {
        int start = 0, last = arr1.length-1,mid;
        while(start<last){
            mid = (start+last)/2;
            if(arr1[mid] >=num){
                last = mid;
            }else{
                start = mid+1;
            }
        }
        return last;
    }

    public static int upper_bound(int num) {
        int start = 0, last = arr1.length-1,mid;
        while(start<last){
            mid = (start+last)/2;
            if(arr1[mid] > num){
                last = mid;
            }else{
                start = mid+1;
            }
        }
        if(arr1[last] == num) last++;
        return last;
    }
}
