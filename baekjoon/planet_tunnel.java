package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class planet_tunnel {
    static class Point{
        int num,x,y,z;

        Point(int num, int x, int y, int z){
            this.num = num;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static class Edge implements Comparable<Edge>{
        int start, end,weight;

        Edge(int start,int end, int weight){
            this.start = start;
            this.end =end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }

    static int[] parent;
    static ArrayList<Edge> edgeList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Point[] points = new Point[n];
        for(int i = 0; i<n;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            points[i] = new Point(i,x,y,z);
        }
        edgeList = new ArrayList<>();

        Arrays.sort(points, (p1,p2)->p1.x - p2.x);
        for(int i = 0; i<n-1;i++){
            int weight = Math.abs(points[i].x - points[i+1].x);

            edgeList.add(new Edge(points[i].num,points[i+1].num,weight));
        }

        Arrays.sort(points, (p1,p2)->p1.y - p2.y);
        for(int i = 0; i<n-1;i++){
            int weight = Math.abs(points[i].y - points[i+1].y);

            edgeList.add(new Edge(points[i].num,points[i+1].num,weight));
        }

        Arrays.sort(points, (p1,p2)->p1.z - p2.z);
        for(int i = 0; i<n-1;i++){
            int weight = Math.abs(points[i].z - points[i+1].z);

            edgeList.add(new Edge(points[i].num,points[i+1].num,weight));
        }

        parent = new int[n];
        for(int i = 0; i<n;i++){
            parent[i] = i;
        }

        Collections.sort(edgeList);
        int ans = 0;
        for(int i = 0; i<edgeList.size();i++){
            Edge edge = edgeList.get(i);

            if(find(edge.start) != find(edge.end)){
                ans += edge.weight;
                union(edge.start,edge.end);
            }
        }
        bw.write(ans+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y){
            parent[x] = y;
        }
    }

    private static int find(int x) {
        if(x == parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}