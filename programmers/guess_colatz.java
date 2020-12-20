package programmers;

public class guess_colatz {
    public static void main(String args[]){
        int num = 626331;
        System.out.println(solution(num));
    }
    public static int solution(int num){
        int answer = 0;
        // int형이지만 *3을 할경우 범위를 넘어가 잘못된 결과값이 나오는 듯하다
        long number = (long)num;
        while(number !=1){
            if(number % 2 == 0){
                number /=2;
            }else{
                number = number*3 +1;
            }
            answer++;
            if(answer == 500){
                answer= -1;
                break;
            }
        }
        return answer;
    }
}
