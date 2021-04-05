package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class minimum_spanning_tree {
    static class edge implements Comparable<edge>{
        int s,e,v;

        public edge(int s, int e, int v){
            this.s = s;
            this.e = e;
            this.v = v;
        }

        @Override
        public int compareTo(edge o) {
            return o.v>=this.v ? -1:1;
        }
    }
    static int n,m;
    static int[] parent;
    static PriorityQueue<edge> pq = new PriorityQueue<edge>();
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];

        for(int i = 0; i<n+1;i++){
            parent[i] = i;
        }
        for(int i = 0; i<m;i++){
            st = new StringTokenizer(br.readLine());
            pq.add(new edge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        for(int i = 0; i<m;i++){
            edge tmp = pq.poll();

            int a = find(tmp.s);
            int b = find(tmp.e);

            if(a==b) continue;
            union(a,b);
            result += tmp.v;
        }
        System.out.println(result);
    }
    public static int find(int a){
        if(a == parent[a]) return a;
        parent[a] = find(parent[a]);
        return parent[a];
    }
    public static void union(int a,int b){
        int aroot = find(a);
        int broot = find(b);

        if(aroot != broot){
            parent[aroot] = b;
        }
    }
}
