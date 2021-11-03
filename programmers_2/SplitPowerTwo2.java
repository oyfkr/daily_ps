package programmers_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SplitPowerTwo2 {

    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        System.out.println(solution(n,wires));
    }

    static int bfsNum = 1;
    static Queue<Integer> q = new LinkedList<>();

    public static int solution(int n, int[][] wires){
        int answer = Integer.MAX_VALUE;
        List<List<Integer>> map = new ArrayList<>();

        for(int i = 0; i<=n;i++){
            map.add(new ArrayList<>());
        }

        for(int[] wire : wires){
            map.get(wire[0]).add(wire[1]);
            map.get(wire[1]).add(wire[0]);
        }

        for(int[] wire:wires){
            map.get(wire[0]).remove((Integer)wire[1]);
            map.get(wire[1]).remove((Integer)wire[0]);

            bfs(map,n);
            answer = Math.min(Math.abs(n-bfsNum-bfsNum),answer);
            bfsNum = 1;

            map.get(wire[0]).add(wire[1]);
            map.get(wire[1]).add(wire[0]);
        }

        return answer;
    }

    public static void bfs(List<List<Integer>> map,int n){
        boolean[] check = new boolean[n+1];
        check[1] = true;
        q.add(1);
        while (!q.isEmpty()){
            List<Integer> list = map.get(q.poll());
            for(int i : list){
                if(!check[i]){
                    q.add(i);
                    check[i] = true;
                    bfsNum += 1;
                }
            }
        }
    }
}
