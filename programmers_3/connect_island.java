package programmers_2;

import java.util.Arrays;
import java.util.Comparator;

public class connect_island {
    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {{0,1,1,},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        connect_island s = new connect_island();
        System.out.println(s.solution(n,costs));
    }

    public int solution(int n, int[][] costs){
        int answer = 0;

        //입력받은 배열에서 비응으로 오름차순을 만든다
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        // 다리를 연결했는지를 위한 boolean
        boolean[] bridge = new boolean[costs.length];
        // 방문했는지 확인하기 위한 boolean
        boolean[] visit = new boolean[n];
        // 맨처음 배열의 원소를 이용해 처음 원소의 0번째와 1번째 섬들은 방문한 것으로 만든다
        visit[costs[0][0]] = true;
        visit[costs[0][1]] = true;
        //0번째는 다리 건설
        bridge[0] = true;
        //비용을 answer에 더한다
        answer = costs[0][2];

        //두개의 섬을 연결한 것이므로 연결된 섬은 두개다.
        int island = 2;

        // 연결된 섬이 n개보다 작을 때까지 반복
        while(island<n){
            for(int i = 1; i< bridge.length;i++){
                // 다리가 건설되지 않았거나 원소의 0번째나 1번째중 하나만 연결됐을 때 if문안으로 들어간다.
                if(!bridge[i] && ((visit[costs[i][0]] &&!visit[costs[i][1]])|| (visit[costs[i][1]] && !visit[costs[i][0]]))){
                    answer += costs[i][2];
                    island++;
                    visit[costs[i][0]]= true;
                    visit[costs[i][1]]= true;
                    bridge[i] = true;
                    break;
                }
            }
        }
        return answer;
    }
}

