import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class menu_renewal {
    public static void main(String[] args) {
        menu_renewal s = new menu_renewal();
        String[] orders = {"ABCFG","AC","CDE","ACDE","BCFG","ACDEH"};
        int[] course = {2,3,4};
        System.out.println(Arrays.toString(s.solution(orders,course)));
    }

    static Map<String,Integer> map;
    static int m;
    public String[] solution(String[] orders,int[] course){
        PriorityQueue<String> pq = new PriorityQueue<>();

        for(int i : course){
            m = 0;
            map = new HashMap<>();
            for(String s : orders){
                find(0,"",0,s,i);
            }
            for(String key : map.keySet()){
                if(map.get(key) == m && m>1){
                    pq.offer(key);
                }
            }
        }
        String[] answer = new String[pq.size()];
        for(int i = 0; i< answer.length;i++){
            answer[i] = pq.poll();
        }
        return answer;
    }

    public void find(int cnt,String now,int index,String word,int targetNum){
        if(cnt == targetNum){
            char[] cs = now.toCharArray();
            Arrays.sort(cs);
            String tmp = "";
            for(char c : cs){
                tmp += c;
            }
            map.put(tmp,map.getOrDefault(tmp,0)+1);
            m = Math.max(m,map.get(tmp));
            return;
        }
        for(int a = index; a<word.length();a++){
            char s = word.charAt(a);
            find(cnt+1,now+s,a+1,word,targetNum);
        }
    }
}
