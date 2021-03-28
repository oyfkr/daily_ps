package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class bipartite_graph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt(); // 정점의 수
            int m = sc.nextInt(); // 간선의 수

            ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n+1];

            // 정점만큼 리스트 생성
            for(int i = 1; i<=n;i++){
                a[i] = new ArrayList<>();
            }

            for(int i = 0; i<m; i++){
                int part1 = sc.nextInt();
                int part2 = sc.nextInt();

                a[part1].add(part2);
                a[part2].add(part1);
            }

            // 정점의 방문 여부 0 : 방문 x , 1 : part1방문 2 : part2방문
            int[] color = new int[n+1];

            boolean ok = true;

            for(int i = 1; i<=n; i++){
                if(color[i] == 0){
                    dfs(a,color,i,1);
                }
            }
            for(int i = 1; i<=n;i++){
                for(int j : a[i]){
                    if(color[i] == color[j]){
                        ok = false;
                    }
                }
            }
            if(ok){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    private static void dfs(ArrayList<Integer>[] a, int[] color, int x, int c) {
        color[x] = c;
        for(int y : a[x]){
            if(color[y] == 0){
                dfs(a,color,y,3-c);
            }
        }
    }
}
