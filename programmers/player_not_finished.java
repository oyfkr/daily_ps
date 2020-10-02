import java.util.ArrayList;
import java.util.Arrays;

public class player_not_finished {
    public static void main(String args[]){
        String[] participant = {"a", "b", "c", "d", "e"};
        String[] completion = {"a", "c", "b", "e"};

        System.out.println(solution(participant, completion));
    }
    public static String solution(String[] participant, String[] completion){
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i = 0; i < completion.length; i++){
            if(!participant[i].equals(completion[i])){
                answer = participant[i];
            }
            answer = participant[completion.length];
        }

        return answer;
    }
}

