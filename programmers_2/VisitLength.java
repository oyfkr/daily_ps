package programmers_2;

import java.util.Arrays;
import java.util.HashSet;

public class VisitLength {

    public static void main(String[] args) {
        VisitLength v = new VisitLength();
        System.out.println(v.solution("UDU"));
    }

    // U : 위쪽으로 한 칸
    // D : 아래쪽으로 한 칸
    // R : 오른쪽으로 한 칸
    // L : 왼쪽으로 한 칸
    // (0,0)에서 시작  -5~5
    public int solution(String dirs){
        int len = dirs.length();
        HashSet<String> s = new HashSet<>();

        int curX = 0;
        int curY = 0;


        for(int i = 0; i<len;i++){
            int nextX = curX;
            int nextY = curY;
            String road ="";

            if(dirs.charAt(i) == 'U'){
                nextY++;
                road +=curX;
                road +=curY;
                road +=nextX;
                road +=nextY;
            }else if(dirs.charAt(i) == 'D'){
                nextY--;
                road +=nextX;
                road +=nextY;
                road +=curX;
                road +=curY;
            }else if(dirs.charAt(i) == 'R'){
                nextX++;
                road +=curX;
                road +=curY;
                road +=nextX;
                road +=nextY;
            }else if(dirs.charAt(i) =='L'){
                nextX--;
                road +=nextX;
                road +=nextY;
                road +=curX;
                road +=curY;
            }
            if(nextX <-5 || nextY < -5 ||nextX>5||nextY>5){
                continue;
            }
            s.add(road);
            curX = nextX;
            curY = nextY;
        }

        return s.size();
    }
}
