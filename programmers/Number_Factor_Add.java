package programmers;

public class Number_Factor_Add {

    public static void main(String[] args) {
        Number_Factor_Add n = new Number_Factor_Add();
        System.out.println(n.solution(13,17));
    }

    public int solution(int left, int right){
        int answer = 0;
        int tmp = 0;

        for(int i = left; i<=right;i++){
            for(int j = 1; j<=i;j++){
                if(i % j == 0){
                    tmp++;
                }
            }
            if(tmp % 2 == 0){
                answer+=i;
            }else{
                answer-=i;
            }
            tmp = 0;
        }

        return answer;
    }
}
