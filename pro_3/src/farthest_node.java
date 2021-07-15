import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class farthest_node {
    public static void main(String[] args) {
        int n = 6;
        int[][] vertex = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
        farthest_node f = new farthest_node();
        System.out.println(f.solution(n,vertex));
    }
    public int solution(int n, int[][] vertex){
        int[] check = new int[n+1];
        check[1] = 1;

        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while(!q.isEmpty()){
            int node = q.poll();
            for(int i = 0;i< vertex.length;i++){
                if(node == vertex[i][0] && check[vertex[i][1]] == 0){
                    check[vertex[i][1]] = check[vertex[i][0]] + 1;
                    q.add(vertex[i][1]);
                }
                if(node == vertex[i][1] && check[vertex[i][0]] == 0){
                    check[vertex[i][0]] = check[vertex[i][1]] + 1;
                    q.add(vertex[i][0]);
                }
            }
        }
        Arrays.sort(check);
        int answer = 0;
        int max = check[check.length-1];
        for(int i : check){
            if(i == max){
                answer++;
            }
        }
        return answer;
    }
}
