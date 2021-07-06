import java.util.ArrayList;

public class maximize_formula {
    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
        maximize_formula s = new maximize_formula();
        System.out.println(s.solution(expression));
    }

    static ArrayList<Long> nums = new ArrayList<>();
    static ArrayList<Character> ops = new ArrayList<>();
    static char[] prior = {'+','-','*'};
    static boolean[] visit = new boolean[3];
    static long answer = 0;

    public Long solution(String expression){
        String num = "";
        for(int i = 0; i<expression.length();i++){
            if(expression.charAt(i) >= '0' && expression.charAt(i) <='9'){
                num += expression.charAt(i);
            }else{
                nums.add(Long.parseLong(num));
                num = "";
                ops.add(expression.charAt(i));
            }
        }
        nums.add(Long.parseLong(num));
        dfs(0,new char[3]);

        return answer;
    }
    public Long calc(Long a, Long b, char op){
        if(op == '+') return a+b;
        if(op == '-') return a-b;
        return a*b;
    }


    public void dfs(int index,char[] p){
        if(index == 3){
            ArrayList<Long> cNums = new ArrayList<>(nums);
            ArrayList<Character> cOps = new ArrayList<>(ops);
            for(int i = 0; i<p.length;i++){
                for(int j = 0; j<cOps.size();j++){
                    if(p[i] == cOps.get(j)){
                        Long tmp = calc(cNums.remove(j),cNums.remove(j),cOps.remove(j));
                        cNums.add(j,tmp);
                        j--;
                    }
                }
            }
            answer = Math.max(answer,Math.abs(cNums.get(0)));
            return;
        }
        for(int i = 0; i<3;i++){
            if(!visit[i]){
                visit[i] = true;
                p[index] = prior[i];
                dfs(index+1,p);
                visit[i] = false;
            }
        }
    }
}
