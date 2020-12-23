package programmers_2;

public class fine_square {
    public static void main(String args[]){
        int w = 8;
        int h = 12;
        System.out.println(solution(w,h));
    }
    // 자른 선이 지나가는 네모가 최대공약수랑 관련이 있는거 같음
    // 가로든 세로든 최대공약수로 나눈 값이 작은 네모들의 개수가 된다.
    // 작은 네모들에서 선에 영향을 안받는 애들이 있음
    // ex)5*2 네모를 지나갈 때 가로로 5칸 세로로 2칸을 간다
    // 근데 여기서 한칸은 세로이기도 하고 가로이기도 하므로 중복이 된다 따라서 -1을 해준다
    public static long solution(int w , int h){
        long answer = (long)w *h;
        int tmp=0;
        int smallx = w;
        int smally = h;
        //최대공약수 w로 만듦
        while(h != 0){
            tmp = w % h;
            w = h;
            h = tmp;
        }
        smallx = smallx/w;
        smally = smally/w;
        answer = answer - (smallx + smally -1) * w;
        return answer;
    }
}
