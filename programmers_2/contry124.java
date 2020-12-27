package programmers_2;

public class contry124 {
    public static void main(String args[]){
        int n = 10;
        System.out.println(solution(n));
    }
    public static String solution(int n){
        //처음에 모든 조건을 다 걸었더니 효율성 문제가 발생
        // 거기에 몇개 안되는것도 발생
        // 애초에 만들고 시작해보자 라는 생각을 함
        String[] answer1 = {"4","1","2"};
        String answer = "";
        int na=0;
        //3으로 나눴을때 나머지와 몫으로 계산 나머지가 0이면
        //몫을 -1을 해주고 4를 넣어주면 된다.
        while(n>0){
            na = n % 3;
            n = n/3;

            if(na == 0) n--;
            answer = answer1[na] + answer;
        }

        return  answer;
    }
}
