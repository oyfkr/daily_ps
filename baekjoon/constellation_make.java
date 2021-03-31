package baekjoon;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Point1{
    int num;
    double x;
    double y;

    Point1(int num, double x, double y){
        this.num = num;
        this.x = x;
        this.y = y;
    }
}

class Edge implements Comparable<Edge>{
    int start;
    int end;
    double weight;

    Edge(int start, int end, double weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
    @Override
    public int compareTo(Edge o){
        if(weight < o.weight){
            return -1;
        }
        return 1;
    }
}

public class constellation_make {
    static int[] parent;
    static ArrayList<Edge> edgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Point1[] point1s = new Point1[N];

        for(int i = 0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            point1s[i] = new Point1(i,x,y);
        }

        edgeList = new ArrayList<>();
        for(int i = 0; i<N;i++){
            for(int j = i+1;j<N;j++){
                double weight = distance(point1s[i],point1s[j]);

                edgeList.add(new Edge(point1s[i].num,point1s[j].num,weight));
            }
        }

        Collections.sort(edgeList);

        parent = new int[N];
        for(int i = 0; i<N;i++){
            parent[i] = i;
        }
        double ans = 0;

        for(int i = 0; i<edgeList.size();i++){
            Edge edge = edgeList.get(i);

            if(find(edge.start) != find(edge.end)){
                ans += edge.weight;
                union(edge.start, edge.end);
            }
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    public static double distance(Point1 p1, Point1 p2){
        return Math.sqrt(Math.pow(p1.x - p2.x,2) + Math.pow(p1.y - p2.y,2));
    }

    public static int find(int x){
        if(x == parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x != y){
            parent[y] = x;
        }
    }
}
