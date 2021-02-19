package programmers_3;


public class Integer_triangle2 {
    public static void main(String[] args) {
        Integer_triangle2 s = new Integer_triangle2();
        int[][] triangle = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
        System.out.println(s.solution(triangle));
    }
    public int solution(int[][] triangle){
        int answer = 0;
        int n = triangle.length;
        int[][] trianswer = new int[n][n];

        trianswer[0][0] = triangle[0][0];

        for(int i = 1;i<n;i++){
            for(int j = 0;j<=i;j++){
                int cur = triangle[i][j];
                if(j == 0){
                    trianswer[i][j] = trianswer[i-1][j] + cur;
                }else if(j == i){
                    trianswer[i][j] = trianswer[i-1][j-1] + cur;
                }else{
                    trianswer[i][j] = Math.max(trianswer[i-1][j] + cur,trianswer[i-1][j-1] + cur);
                }
            }
        }
        for(int i = 0;i< trianswer[triangle.length-1].length;i++){
            if(answer < trianswer[trianswer.length-1][i]){
                answer = trianswer[trianswer.length-1][i];
            }
        }
        return answer;
    }
}
