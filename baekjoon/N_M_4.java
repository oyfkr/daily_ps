package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_M_4 {
    static int N;
    static int M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        dfs(1,0);
        System.out.println(sb);
    }

    public static void dfs(int cur,int depth){
        if(depth == M){
            for(int i = 0; i<M;i++){
                sb.append(arr[i]).append(' ');
            }
            sb.append("\n");
            return;
        }
        for(int i = cur;i<=N;i++){

            arr[depth] = i;
            dfs(i,depth+1);
        }
    }
}
