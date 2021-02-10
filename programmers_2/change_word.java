package programmers_2;

public class change_word {
    public static void main(String[] args) {
        change_word s = new change_word();
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot","dot","dog","lot","log","cog"};
        System.out.println(s.solution(begin,target,words));
    }
    static int answer = 0;
    public int solution(String begin, String target, String[] words){
        answer = 51;
        boolean[] check = new boolean[words.length];
        dfs(begin,target,words,0,check);
        if(answer == 51){
            answer = 0;
        }
        return answer;
    }
    public void dfs(String begin, String target, String[] words,int cnt,boolean[] check){
        if(begin.equals(target)){
            if(answer > cnt){
                answer = cnt;
            }
            return;
        }

        for(int i = 0; i< words.length;i++){
            int dif = 0;
            for(int j = 0; j<begin.length();j++){
                if(begin.charAt(j) != words[i].charAt(j)){
                    dif++;
                }
            }
            if(!check[i] && dif == 1){
                check[i] = true;
                dfs(words[i],target,words,cnt+1,check);
                check[i] = false;
            }
        }
    }
}
