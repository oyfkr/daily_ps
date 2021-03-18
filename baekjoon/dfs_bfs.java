package baekjoon;

import java.util.*;

public class dfs_bfs {

    public static boolean[] check;
    public static ArrayList<Integer> list[];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int start = scan.nextInt();

         list = new ArrayList[n+1];

        for(int i = 1;i<n+1;i++){
            list[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i<m;i++){
            int a = scan.nextInt();
            int b = scan.nextInt();

            list[a].add(b);
            list[b].add(a);
        }
        for(int i = 1; i<n+1;i++){
            Collections.sort(list[i]);
        }

        check = new boolean[n+1];
        dfs(start);
        System.out.println();

        check = new boolean[n+1];
        bfs(start);

        scan.close();
    }

    public static void dfs(int cur){
        if(check[cur]){
            return;
        }
        check[cur] = true;
        System.out.print(cur + " ");
        for(int i : list[cur]){
            if(!check[i]){
                dfs(i);
            }
        }
    }

    public static void bfs(int cur){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(cur);
        check[cur] = true;

        while(!queue.isEmpty()){
            int a = queue.poll();
            System.out.print(a + " ");
            for(int i : list[a]){
                if(!check[i]){
                    check[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
