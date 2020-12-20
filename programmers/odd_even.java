package programmers;

public class odd_even {
    public static void main(String args[]){
        int n = 3;
        System.out.println(solutuon(n));
    }
    public static String solutuon(int n){
        String answer = "";
        if(n % 2 == 0){
            answer = "Even";
            return  answer;
        }answer = "Odd";
        return answer;
    }
}
