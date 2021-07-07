import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class compression {
    public static void main(String[] args) {
        String msg = "KAKAO";
        compression c = new compression();
        System.out.println(Arrays.toString(c.solution(msg)));
    }

    public int[] solution(String msg){
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        char ch = 'A';
        for(int i = 1; i<27;i++){
            map.put(ch+"",i);
            ch++;
        }
        int mapNum = 27;
        boolean flag = false;
        for(int i = 0; i<msg.length();i++){
            String tmp = msg.charAt(i) + "";
            while(map.containsKey(tmp)){
                i++;
                if(i == msg.length()){
                    flag = true;
                    break;
                }
                tmp += msg.charAt(i);
            }
            if(flag){
                ans.add(map.get(tmp));
                break;
            }
            ans.add(map.get(tmp.substring(0,tmp.length()-1)));
            map.put(tmp,mapNum++);
            i--;
        }
        int[] answer = new int[ans.size()];
        for(int i = 0; i<ans.size();i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}
