package programmers_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FiveDictionary {
    public static void main(String[] args) {
        System.out.println(solution("AAAAE"));
    }

    static char[] arr = {'A','E','I','O','U'};
    static List<String> ans;

    public static int solution(String word){
        int answer = 0;
        ans = new ArrayList<>();
        int index = 1;

        for(int i = 1; i<=5;i++){
            dfs(0, "",i);
        }

        Collections.sort(ans);

        for(String tmp : ans){
            if(tmp.equals(word)){
                answer = index;
                break;
            }
            index++;
        }
        return answer;
    }

    public static void dfs(int depth, String tmp, int len){
        if(depth == len){
            ans.add(tmp);
            return;
        }
        for(int i = 0; i<5;i++){
            dfs(depth+1,tmp+arr[i],len);
        }
    }
}
