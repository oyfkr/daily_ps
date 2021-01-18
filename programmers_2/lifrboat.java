package programmers_2;

import java.util.Arrays;

public class lifrboat {
    public static void main(String[] args) {
        int[] people ={70,50,80,50};
        int limit = 100;
        lifrboat s = new lifrboat();
        System.out.println(s.solution(people,limit));
    }
    public int solution(int[] people, int limit){
        int answer = 0;
        int cur = people.length-1;
        Arrays.sort(people);

        for(int i=0; i<=cur; i++,answer++) {
            while (cur > i && people[i] + people[cur--] > limit)
                answer++;
        }
        return answer;
    }
}
