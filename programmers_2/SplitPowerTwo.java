package programmers_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class SplitPowerTwo {

    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        System.out.println(solution(n,wires));
    }

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
            int node = dfs(map,wire[0],wire[0],wire[1],new boolean[n+1]);
            answer = Math.min(Math.abs(n-node-node),answer);
        }

        return answer;
    }

    public static int dfs(List<List<Integer>> map, int start, int i1, int i2, boolean[] check){
        if(check[start]) return 0;
        check[start] = true;
        int node = 1;
        List<Integer> integers = map.get(start);
        for (Integer i : integers) {
            if((start==i1 && i ==i2) || (start==i2 && i==i1)) continue;
            node += dfs(map,i,i1,i2,check);
        }
        return node;
    }
}
