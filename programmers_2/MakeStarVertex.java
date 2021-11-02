package programmers_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MakeStarVertex {

    public static void main(String[] args) {
        int[][] line = {{2,-1,4},{-2,-1,4},{0,-1,1},{5,-8,-12},{5,8,12}};
        System.out.println(Arrays.toString(solution(line)));
    }

    public static String[] solution(int[][] line){
        String[] answer = {};
        List<List<Integer>> list = new ArrayList<>();
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;


        for(int i = 0; i<line.length-1;i++){
            for(int j = i+1;j< line.length;j++){
                long a = line[i][0];
                long b = line[i][1];
                long e = line[i][2];

                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];

                long parent = (a*d) - (b*c);

                if(parent == 0) continue;

                long xChild = (b*f) - (e*d);
                long yChild = (e*c) - (a*f);

                if(xChild % parent != 0 || yChild % parent != 0) continue;

                int x = (int) (xChild/parent);
                int y = (int) (yChild/parent);
                List<Integer> lis = Arrays.asList(x,y);

                if(!list.contains(lis)){
                    list.add(lis);
                }

                minX = Math.min(x,minX);
                minY = Math.min(y,minY);
                maxX = Math.max(x,maxX);
                maxY = Math.max(y,maxY);
            }
        }

        List<String> board = new ArrayList<>();
        for(int i = minY; i<=maxY;i++){
            StringBuilder sb = new StringBuilder();
            for(int j = minX; j<=maxX;j++){
                sb.append(".");
            }
            board.add(sb.toString());
        }

        for(List<Integer> tmp : list){
            StringBuilder sb = new StringBuilder(board.get(Math.abs(tmp.get(1)-maxY)));
            sb.setCharAt(Math.abs(tmp.get(0)-minX),'*');
            board.set(Math.abs(tmp.get(1)-maxY),sb.toString());
        }

        answer = new String[board.size()];
        for(int i = 0; i< answer.length;i++){
            answer[i] = board.get(i);
        }

        return answer;
    }
}
