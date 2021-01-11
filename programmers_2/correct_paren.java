package programmers_2;

import java.util.Stack;

public class correct_paren {
    public static void main(String[] args) {
        String s = ")(()";
        correct_paren a = new correct_paren();
        System.out.println(a.solution(s));
    }
    public boolean solution(String s){
        boolean answer = true;
        int right = 0;
        int left = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<s.length();i++){
            if(s.charAt(i) == '('){
                stack.push('(');
                left++;
            }else{
                if(stack.empty()){
                    return false;
                }
                stack.pop();
                right++;
            }
        }
        if(left != right){
            answer = false;
        }
        return answer;
    }
}
