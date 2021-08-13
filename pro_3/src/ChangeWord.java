public class ChangeWord {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String words[] = {"hot","dot","dog","lot","log","cog"};
        ChangeWord c = new ChangeWord();
        System.out.println(c.solution(begin,target,words));
    }

    static String tar;
    static boolean[] check;
    static int answer;
    public int solution(String begin, String target, String[] words){
        answer = 51;
        check = new boolean[words.length];
        tar = target;
        dfs(begin,0,words);

        if(answer == 51){
            return 0;
        }

        return answer;
    }

    public void dfs(String begin,int cnt,String[] words){
        if(begin.equals(tar)){
            answer = Math.min(answer,cnt);
        }

        for(int i = 0; i< words.length;i++){
            int dif = 0;
            for(int j = 0; j<words[0].length();j++){
                if(begin.charAt(j) != words[i].charAt(j)){
                    dif++;
                }
            }
            if(dif == 1 && !check[i]){
                check[i] = true;
                dfs(words[i],cnt+1,words);
                check[i] = false;
            }
        }
    }
}
