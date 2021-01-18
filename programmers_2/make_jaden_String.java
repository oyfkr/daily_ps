package programmers_2;

import java.util.ArrayList;

public class make_jaden_String {
    public static void main(String[] args) {
        String s = "for the last week";
        make_jaden_String a = new make_jaden_String();
        System.out.println(a.solution(s));
    }
    public String solution(String s){
        String answer = "";
        ArrayList<Character>array = new ArrayList<>();
        for(int i = 0; i<s.length();i++){
            if(array.size() == 0){
                if('a'<=s.charAt(i) && s.charAt(i)<='z'){
                    array.add((char)(s.charAt(i)-32));
                }else {
                    array.add(s.charAt(i));
                }
            }
            else if(array.get(array.size()-1) == ' ' && 'a'<=s.charAt(i) && s.charAt(i)<=122){
                array.add((char)(s.charAt(i)-32));
            }else if(array.get(array.size()-1) != ' ' && 'A'<=s.charAt(i) && s.charAt(i)<='Z'){
                array.add((char)(s.charAt(i)+32));
            }else {
                array.add(s.charAt(i));
            }
        }
        for(int i = 0; i< array.size();i++){
            answer += array.get(i);
        }
        return answer;
    }
}
