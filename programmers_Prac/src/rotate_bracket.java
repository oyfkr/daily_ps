import java.util.Stack;

public class rotate_bracket {
    public static void main(String[] args) {
        String s = "[](){}";
        rotate_bracket r = new rotate_bracket();
        System.out.println(r.solution(s));
    }
    public int solution(String s){
        int answer = 0;

        for(int i = 0; i<s.length();i++){
            Stack<Character> stack = new Stack<>();
            stack.add(s.charAt(0));
            for(int j = 1; j<s.length();j++){
                if(stack.isEmpty()){
                    stack.add(s.charAt(j));
                    continue;
                }if(stack.peek().equals(']') || stack.peek().equals('}') || stack.peek().equals(')')){
                    break;
                }else if(s.charAt(j) == ')' && stack.peek().equals('(')){
                    stack.pop();
                }else if(s.charAt(j) == '}' && stack.peek().equals('{')){
                    stack.pop();
                }else if(s.charAt(j) == ']' && stack.peek().equals('[')){
                    stack.pop();
                }else{
                    stack.add(s.charAt(j));
                }
            }
            if(stack.size() == 0){
                answer++;
            }
            char tmp = s.charAt(0);
            s = s.substring(1);
            s += tmp;
        }

        return answer;
    }
}
