package programmers_2;

import java.util.Arrays;

public class Dialysis_traffic {
    public static void main(String[] args) {
        Dialysis_traffic s = new Dialysis_traffic();
        String[] lines ={"2016-09-15 01:00:04.002 2.0s"
        ,"2016-09-15 01:00:07.000 2s"};
        System.out.println(s.solution(lines));
    }
    public int solution(String[] lines){
        int answer = 0;

        // lines의 한 원소의 끝나는 시간에 1을 더하고 그값에 얼마나 많은 값들이 시작하는지를 비교하고 저장하기 위한 배열
        int[] cnt = new int[lines.length];
        double complete;

        for(int i = 0; i<lines.length;i++){
            //앞에 날짜는 시간을 계산하는데 의미가 없기때문에 지워주소 :과 s는 아무것도 없는 것으로 대체한다.
            lines[i] = lines[i].substring(11).replace(":","").replace("s","");

            //전체를 초로 바꿔주기 위한 코드
            int sec = Integer.parseInt(lines[i].substring(0,2))*3600 +
                    Integer.parseInt(lines[i].substring(2,4))*60+
                    Integer.parseInt(lines[i].substring(4,6));

            lines[i] = ""+ sec + lines[i].substring(6);
        }
        System.out.println(Arrays.toString(lines));
        for(int i = 0; i< lines.length;i++){
            //\\s를 이용하여 빈칸으로 다 쪼갠다
            String[] split = lines[i].split("\\s");
            //완료시간을 구해논다
            complete = Double.parseDouble(split[0]);

            double area = complete+1;

            for(int j = i;j< lines.length;j++){
                split = lines[j].split("\\s");

                //시작시간구하기
                double start = Double.parseDouble(split[0]) - Double.parseDouble(split[1]) + 0.001;
                if(start < area){
                    cnt[i]++;
                }
            }
        }
        //cnt배열에서 최대값 구하기
        for(int i = 0; i< cnt.length;i++){
            if(answer < cnt[i]) answer = cnt[i];
        }
        return answer;
    }
}
