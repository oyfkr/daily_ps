package programmers_2;

public class N_least_common_mul {
    public static void main(String[] args) {
        N_least_common_mul s = new N_least_common_mul();
        int[] arr = {2,6,8,14};
        System.out.println(s.solution(arr));
    }
    public int solution(int[] arr){
        int answer = arr[0];
        for(int i = 0; i<arr.length;i++){
            answer = min(answer,arr[i]);
        }
        return answer;
    }
    public static int max(int a, int b){
        while(b!=0){
            int r = a%b;
            a=b;
            b=r;
        }
        return a;
    }
    public static int min(int a, int b){
        return a*b/max(a,b);
    }
}
