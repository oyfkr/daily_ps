package programmers_2;

public class popping_balloon {
    public static void main(String[] args) {
        popping_balloon s = new popping_balloon();
        int[] a = {-16,27,65,-2,58,-92,-71,-68,-61,-33};
        System.out.println(s.solution(a));
    }
    public int solution(int[] a){
        int answer = 0;
        int lef = 1000000000;
        int rig = 1000000000;
        for(int i = 0;i<a.length;i++){
            if(a[i] < lef){
                lef = a[i];
                answer++;
            }
            if(a[a.length-i-1] < rig){
                rig = a[a.length-i-1];
                answer++;
            }
            if(lef == rig){
                break;
            }
        }
        if(lef == rig){
            answer--;
        }
        return answer;
    }
}
