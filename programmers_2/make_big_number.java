package programmers_2;

import java.util.Stack;

public class make_big_number {
    public static void main(String args[]){
        String number = "4177252841";
        int k = 4;
        make_big_number s = new make_big_number();
        System.out.println(s.solution(number,k));
    }
    public String solution(String number, int k){
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<number.length();i++){
            while(!stack.empty() && k > 0 && stack.peek() < number.charAt(i)){
                stack.pop();
                k--;
            }
            stack.push(number.charAt(i));
        }
        while(!stack.empty()){
            if(k != 0){
                stack.pop();
                k--;
            }else{
                answer = stack.pop() + answer;
            }
        }

        return answer;
    }
}
