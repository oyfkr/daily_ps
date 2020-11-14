package programmers;


public class renting_uniform {
    public static void main(String args[]){
        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {1,3,5};
        System.out.println(solution(n,lost,reserve));
    }
    public static int solution(int n, int[] lost,int[] reserve){
        int answer = 0;
        int [] cloths = new int[n+2];

        for(int i : lost) cloths[i]--;
        for(int i : reserve) cloths[i]++;

        for(int i = 1; i<n+1;i++){
            if(cloths[i] == -1){
                if(cloths[i-1] == 1){
                    cloths[i-1]--;
                    cloths[i]++;
                }else if(cloths[i+1]==1){
                    cloths[i+1]--;
                    cloths[i]++;
                }
            }
            if(cloths[i] != -1){
                answer++;
            }
        }
        return answer;
    }
}
