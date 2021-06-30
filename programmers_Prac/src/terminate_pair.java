import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class terminate_pair {
    public static void main(String[] args) {
        String s = "baabaa";
        terminate_pair a = new terminate_pair();
        System.out.println(a.solution(s));
    }
    public int solution(String s){
        int answer = 0;

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(!stack.empty() && stack.peek().equals(c)) stack.pop();
            else stack.add(c);
        }
        if(stack.empty()){
            answer = 1;
        }

        return answer;
    }
}
