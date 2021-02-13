package programmers_2;

public class n2_tailling {
    public static void main(String[] args) {
        int n = 4;
        n2_tailling s = new n2_tailling();
        System.out.println(s.solution(4));
    }

    public int solution(int n) {
        int a,b,c=0;
        a = 1;
        b = 1;
        for(int i = 1; i<n;i++){
            c = (a + b) % 1000000007;
            a = b;
            b = c;
        }

        return c;
    }
}
