package programmers_2;

public class expect_draw {
    public static void main(String[] args) {
        expect_draw s = new expect_draw();
        int n = 8;
        int a = 4;
        int b = 7;
        System.out.println(s.solution(n,a,b));
    }
    static int sum = 0;
    public int solution(int n, int a,int b){
        int answer = 0;
        half(n,a,b);
        return sum;
    }

    public void half(int n, int a,int b){
        sum++;
        if((a%2==1) && ((a+1)==b)){
            return;
        }
        if(a % 2 == 1){
            a = (a+1)/2;
        }else{
            a = a/2;
        }
        if(b % 2 == 1){
            b = (b+1)/2;
        }else{
            b = b/2;
        }
        half(n/2,a,b);
    }
}
