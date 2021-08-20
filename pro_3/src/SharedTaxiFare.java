import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SharedTaxiFare {

    public static void main(String[] args) {
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {{4,1,10},{3,5,24},{5,6,2},{3,1,41},{5,1,24},{4,6,50},{2,4,66},{2,3,22},{1,6,25}};

        SharedTaxiFare t = new SharedTaxiFare();
        System.out.println(t.solution(n,s,a,b,fares));
    }

    static class Edge implements Comparable<Edge>{

        int index;
        int cost;

        public Edge(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static final int MAX = 20000001;
    static List<ArrayList<Edge>> graph;
    public int solution(int n, int s, int a, int b, int[][] fares){
        int answer = Integer.MAX_VALUE;

        graph = new ArrayList<>();

        for(int i = 0; i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] i : fares){
            graph.get(i[0]).add(new Edge(i[1], i[2]));
            graph.get(i[1]).add(new Edge(i[0], i[2]));
        }

        int[] startA = new int[n+1];
        int[] startB = new int[n+1];
        int[] startS = new int[n+1];

        Arrays.fill(startA,MAX);
        Arrays.fill(startB,MAX);
        Arrays.fill(startS,MAX);

        startA = dijkstra(a,startA);
        startB = dijkstra(b,startB);
        startS = dijkstra(s,startS);

        for(int i = 1; i<=n;i++){
            answer = Math.min(answer,startA[i] + startB[i] + startS[i]);
        }
        return answer;
    }

    public int[] dijkstra(int start,int[] costs){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        costs[start] = 0;

        while (!pq.isEmpty()){
            Edge now = pq.poll();
            int nowIndex = now.index;
            int nowCost = now.cost;

            // while문을 반복하는 이유가 더 작은 값을 찾는것
            // nowCost는 바로 가는 경우의 cost 하지만 돌아서 가는 방법이 더 cost가 적으면 할 필요가 없음
            if(nowCost > costs[nowIndex]) continue;

            ArrayList<Edge> edges = graph.get(nowIndex);
            for(Edge edge : edges){
                // 현재 index의 최단거리 + 목표로 하는 edge까지의 cost
                int cost = costs[nowIndex] + edge.cost;

                // 목표로 하는 edge의 현재까지의 최단거리보다 더 작은 값이 발견되면 교체
                if(cost < costs[edge.index]){
                    costs[edge.index] = cost;
                    pq.offer(new Edge(edge.index, cost));
                }
            }
        }
        return costs;
    }
}
