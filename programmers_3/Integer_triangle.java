package programmers_3;

public class Integer_triangle {
    public static void main(String[] args) {
        int[][] triangle = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
        Integer_triangle s = new Integer_triangle();
        System.out.println(s.solution(triangle));
    }
    static int answer;
    public int solution(int[][] triangle){
        answer = 0;
        int tmp = triangle[0][0];
        dp(triangle,0,0,tmp);
        return answer;
    }
    public void dp(int[][] triangle, int n,int a,int tmp){
        //System.out.println(tmp);
        if(n+1 == triangle.length){
            if(answer < tmp){
                answer = tmp;
            }
            return;
        }
        tmp += triangle[n+1][a];
        dp(triangle,n+1,a,tmp);
        dp(triangle,n+1,a+1,tmp);
    }
}
