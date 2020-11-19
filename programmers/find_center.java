package programmers;

public class find_center {
    public static void main(String args[]){
        String s = "qwer";
        System.out.println(solution(s));
    }
    public static String solution(String s){
        String answer = "";
        String[] array;
        array = s.split("");
        int len = s.length();
        int a = len /2;
        if(len % 2 == 0){

            answer = array[a-1] + array[a];
        }else{
            answer = array[a];
        }
        return answer;
    }
}
