package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class virus {
    public static ArrayList<Integer> list[];
    public static boolean check[];
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int com = scan.nextInt();
        int line = scan.nextInt();

        list = new ArrayList[com+1];
        check = new boolean[com+1];

        for(int i = 1; i<com+1; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 1; i<line+1;i++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            list[a].add(b);
            list[b].add(a);
        }
        dfs(1);
        System.out.println(cnt-1);
    }
    public static void dfs(int cur){
        if(check[cur]){
            return;
        }
        check[cur] = true;
        cnt++;
        for(int i : list[cur]){
            if(!check[i]){
                dfs(i);
            }
        }
    }
}
