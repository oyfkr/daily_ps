package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class find_treeparent {

    static int n;
    static List<Integer>[] list;
    static boolean[] visit;
    static int[] parents;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        list = new ArrayList[n+1];
        parents = new int[n+1];
        visit = new boolean[n+1];

        for(int i = 1;i<=n;i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i<n-1;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            list[b].add(a);

        }
        dfs(1);
        for(int i = 2;i<=n;i++){
            System.out.println(parents[i]);
        }
    }

    public static void dfs(int v){
        visit[v] = true;

        for(int i : list[v]){
            if(!visit[i]){
                parents[i] = v;
                dfs(i);
            }
        }
    }
}
