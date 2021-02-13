package programmers_3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class farthest_node {
    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
        farthest_node s= new farthest_node();
        System.out.println(s.solution(n,edge));
    }
    public int solution(int n, int[][] edge){
        int answer = 0;

        //방문했는지 확인하기 위한 배열
        int[] rep = new int[n+1];
        rep[1] = 1;

        //bfs를 위한 큐
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while(!queue.isEmpty()){
            int cur = queue.poll();

            for(int i = 0; i< edge.length;i++){
                if(cur == edge[i][0] && rep[edge[i][1]]==0){
                    rep[edge[i][1]] = rep[cur] + 1;
                    queue.add(edge[i][1]);
                }
                if(cur == edge[i][1] && rep[edge[i][0]] == 0){
                    rep[edge[i][0]] = rep[cur] + 1;
                    queue.add(edge[i][0]);
                }
            }
        }
        Arrays.sort(rep);
        int max = rep[rep.length-1];
        for(int i : rep){
            if(i == max) answer++;
        }
        return answer;
    }
}
