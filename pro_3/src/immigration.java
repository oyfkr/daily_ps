import java.util.Arrays;

public class immigration {
    public static void main(String[] args) {
        int n = 6;
        int[] times = {7,10};
        immigration i = new immigration();
        System.out.println(i.solution(n,times));
    }

    public long solution(int n, int[] times){
        long answer = 0;

        Arrays.sort(times);
        long max = (long)times[times.length-1] * n;
        long min = 1;

        while (min < max){
            long mid = (max+min)/2;
            long sum = 0;

            for(int t : times){
                sum += mid/t;
            }

            //sum이 n보다 크다면 더 많은 사람을 검사할 수 있는 시간이었으므로 mid의 값을 줄일 필요가 있다
            //따라서 max 에 mid를 넣고 반대의 경우 min에 max를 넣는다.
            if(sum >= n){
                max = mid;
                answer = mid;
            }else{
                min = mid+1;
            }
        }

        return answer;
    }
}
