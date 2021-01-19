package programmers_2;

import java.util.ArrayList;
import java.util.Collections;

public class jump_teleport {
    public static void main(String[] args) {
        int n = 10;
        jump_teleport s = new jump_teleport();
        System.out.println(s.solution(n));
    }
    ArrayList<Integer> arr = new ArrayList<>();
    public int solution(int n){
        int answer = 0;
        jump_tele(1,n,1);
        Collections.sort(arr);
        answer = arr.get(0);
        return answer;
    }
    public void jump_tele(int cur, int n,int cnt){
        if(cur == n){
            arr.add(cnt);
            return;
        }else if(cur > n){
            return;
        }
        jump_tele(cur*2,n,cnt);
        jump_tele(cur+1,n,cnt+1);
    }
}
