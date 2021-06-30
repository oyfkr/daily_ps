import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class open_chatting2 {
    public static void main(String[] args) {
        open_chatting s = new open_chatting();
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(Arrays.toString(s.solution(record)));
    }

    public String[] solution(String[] record){
        Map<String, String> map = new HashMap<>();
        ArrayList<String> array = new ArrayList<>();
        for(String s : record){
            String[] tmp = s.split(" ");
            if(tmp[1].equals("Enter")){
                map.put(tmp[0],tmp[2]);
                array.add(tmp[1] + "님이 들어왔습니다.");
            }else if(tmp[1].equals("Leave")){
                array.add(tmp[1] + "님이 나갔습니다.");
            }else{
                map.put(tmp[0],tmp[2]);
            }
        }
        String[] answer = new String[array.size()];
        int cnt = 0;
        for(String s : array){
            String tmp = s.split("님")[0];
            answer[cnt] = s.replace(tmp,map.get(tmp));
            cnt++;
        }
        return answer;
    }

}
