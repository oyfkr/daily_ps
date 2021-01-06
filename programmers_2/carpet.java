package programmers_2;

import java.util.Arrays;

public class carpet {
    public static void main(String[] args) {
        int brown = 8;
        int yellow = 1;
        carpet s = new carpet();
        System.out.println(Arrays.toString(s.solution(brown,yellow)));
    }
    public int[] solution(int brown, int yellow){
        //int[] answer = {};
        int height = 3;
        int width = 0;
        while(true){
            width = (brown +4)/2 - height;
            int yellowcount = (width -2) * (height -2);
            if(yellow == yellowcount){
                break;
            }
            height++;
        }
        int[] answer = {width, height};
        return answer;
    }
}
