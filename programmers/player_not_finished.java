package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class player_not_finished {
    public static void main(String args[]){
        String[] participant = {"a", "b", "c", "d", "e"};
        String[] completion = {"a", "e", "d","b"};

        System.out.println(solution(participant, completion));
    }
    public static String solution(String[] participant, String[] completion){
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);
        boolean flag = true;
        for(int i = 0; i < completion.length;  i++){
            if(!participant[i].equals(completion[i])){
                answer = participant[i];
                flag = false;
                break;
            }
        }
        if(flag == true){
            answer = participant[participant.length-1];
        }

        return answer;
    }
}

