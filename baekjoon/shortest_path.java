package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class shortest_path {
    // number노드와 가중치를 저장
    static class Node implements Comparable<Node>{
        int number,weight;

        public Node(int n, int w){
            this.number = n;
            this.weight = w;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    // 방문했는지 여부, 가중치를 저장하기 위한 배열, 연결된 노드들을 저장하기 위한 리스트
    static boolean visit[];
    static int distance[];
    static LinkedList<Node> list[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(stz.nextToken());
        int e = Integer.parseInt(stz.nextToken());
        int start = Integer.parseInt(br.readLine());

        visit = new boolean[v+1];
        list = new LinkedList[v+1];
        distance = new int[v+1];

        Arrays.fill(distance,-1);
        for(int i = 1; i<=v;i++){
            list[i] = new LinkedList<>();
        }
        //각각의 노드에서 연결된 노드를 리스트를 이용해 저장
        for(int i = 0; i<e;i++){
            stz = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(stz.nextToken());
            int v2 = Integer.parseInt(stz.nextToken());
            int w = Integer.parseInt(stz.nextToken());
            list[v1].add(new Node(v2,w));
        }

        dijkstra(start);
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<=v;i++){
            sb.append(distance[i] == -1 ? "INF" : distance[i]).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        distance[start] = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(!visit[now.number]){
                visit[now.number] = true;
                for(Node next : list[now.number]){
                    // 처음 시작할때는 모든 거리가 -1이고 돌아가는 길의 가중치가 더 적은 경우를 찾는다.
                    if(distance[next.number] == -1 || distance[next.number] > distance[now.number] + next.weight){
                        distance[next.number] = distance[now.number] + next.weight;
                        pq.offer(new Node(next.number, distance[next.number]));
                    }
                }
            }
        }
    }
}
