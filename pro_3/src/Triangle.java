public class Triangle {
    public static void main(String[] args) {
        Triangle t = new Triangle();
        int[][] triangle = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
        System.out.println(t.solution(triangle));
    }

    public int solution(int[][] triangle){
        int answer = 0;
        int[][] triAnswer = new int[triangle.length][triangle.length];
        triAnswer[0][0] = triangle[0][0];

        for(int i = 1;i< triangle.length;i++){
            for(int j = 0;j<=i;j++){
                int now = triangle[i][j];
                if(j == 0){
                    triAnswer[i][j] = triAnswer[i-1][j] + now;
                }else if(i==j){
                    triAnswer[i][j] = triAnswer[i-1][j-1] + now;
                }else{
                    triAnswer[i][j] = Math.max(triAnswer[i-1][j-1],triAnswer[i-1][j]) + now;
                }
            }
        }
        for(int i = 0;i< triAnswer.length;i++){
            answer = Math.max(answer,triAnswer[triAnswer.length-1][i]);
        }

        return answer;
    }
}
