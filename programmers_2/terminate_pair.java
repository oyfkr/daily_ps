package programmers_2;

import java.util.ArrayList;
import java.util.Arrays;

public class terminate_pair {
    public static void main(String[] args) {
        String s = "baabaa";
        terminate_pair a = new terminate_pair();
        System.out.println(a.solution(s));
    }
    public int solution(String s){
        int answer = 0;
        ArrayList<Character> array = new ArrayList<>();
        for(int i = 0;i<s.length();i++){
            if(array.size() ==0){
                array.add(s.charAt(i));
            }else if(array.get(array.size()-1) == s.charAt(i)){
                array.remove(array.size()-1);
            }else{
                array.add(s.charAt(i));
            }
        }
        if(array.size() == 0){
            return 1;
        }
        return answer;
    }
}
