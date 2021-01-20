package programmers_2;

import java.util.ArrayList;
import java.util.Arrays;

public class word_connect {
    public static void main(String[] args) {
        word_connect s = new word_connect();
        int n = 2;
        String[] words = {"hello","one","even","never","now","world","draw"};
        System.out.println(Arrays.toString(s.solution(n,words)));
    }
    public int[] solution(int n, String[] words){
        int[] answer = new int[2];
        int cnt = 0;
        ArrayList<String> array = new ArrayList<>();
        for(int i = 0; i< words.length;i++){
            cnt++;
            if(array.size() == 0){
                array.add(words[i]);
            }else if(!array.contains(words[i]) && array.get(array.size()-1).charAt(array.get(array.size()-1).length()-1) == words[i].charAt(0)){
                array.add(words[i]);
            }else{
                int order=0;
                if(i+1 % n == 0){
                    order = i /n;
                }else{
                    order = i/n +1;
                }
                answer[0] = cnt;
                answer[1] = order;
                break;
            }
            if(cnt > n-1){
                cnt = 0;
            }
        }
        return answer;
    }
}
