package programmers_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class travel_route {
    public static void main(String[] args) {
        String[][] tickets = {{"ICN","SFO"},{"ICN","ATL"}
        ,{"SFO","ATL"},{"ATL","ICN"},{"ATL","SFO"}};
        travel_route s = new travel_route();
        System.out.println(Arrays.toString(s.solution(tickets)));
    }
    boolean[] visit;
    ArrayList<String> paths = new ArrayList<>();
    public String[] solution(String[][] tickets){
        visit = new boolean[tickets.length];
        String[] answer = {};
        dfs(tickets,"ICN","ICN",0);
        Collections.sort(paths);
        answer = paths.get(0).split(" ");
        return answer;
    }

    public void dfs(String[][] tickets,String start,String path,int count){
        if(tickets.length == count){
            paths.add(path);
            return;
        }
        for(int i = 0; i< tickets.length;i++){
            if(!visit[i] && tickets[i][0].equals(start)){
                visit[i] = true;
                dfs(tickets,tickets[i][1],path + " " + tickets[i][1],count+1);
                visit[i] = false;
            }
        }
    }
}
