import java.util.HashMap;
import java.util.HashSet;

public class IllegalUser {
    public static void main(String[] args) {
        String[] user_id = {"frodo","fradi","crodo","abc123","frodoc"};
        String[] banned_id = {"fr*d*","abc1**"};
        IllegalUser c = new IllegalUser();
        System.out.println(c.solution(user_id,banned_id));
    }

    static HashSet<String> ban;
    public int solution(String[] user_id, String[] banned_id){
        int answer = 0;
        boolean visit[] = new boolean[user_id.length];
        ban = new HashSet<>();
        dfs(user_id,banned_id,0,visit);
        answer = ban.size();

        return answer;
    }

    public void dfs(String[] user_id, String[] banned_id, int ban_idx, boolean[] visited){
        if(ban_idx == banned_id.length){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<user_id.length;i++){
                if(visited[i]){
                    sb.append(i);
                }
            }
            ban.add(sb.toString());
            return;
        }
        for(int i = 0;i<user_id.length;i++){
            if(visited[i]) continue;
            boolean flag = false;

            if(user_id[i].length() == banned_id[ban_idx].length()){
                for(int j = 0; j<user_id[i].length();j++){
                    if(banned_id[ban_idx].charAt(j) == '*') continue;

                    if(user_id[i].charAt(j) != banned_id[ban_idx].charAt(j)){
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    visited[i] = true;
                    dfs(user_id,banned_id,ban_idx+1,visited);
                    visited[i] = false;
                }
            }
        }
    }
}
