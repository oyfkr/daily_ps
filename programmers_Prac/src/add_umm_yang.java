public class add_umm_yang {
    public static void main(String[] args) {
        add_umm_yang s = new add_umm_yang();
        int[] absolutes = {4,7,12};
        boolean[] signs = {true,false,true};
        System.out.println(s.solution(absolutes,signs));
    }

    public int solution(int[] absolutes, boolean[] signs){
        int answer = 0;
        for(int i=0; i< absolutes.length;i++){
            if(signs[i]){
                answer += absolutes[i];
            }else{
                answer -= absolutes[i];
            }
        }
        return answer;
    }
}
