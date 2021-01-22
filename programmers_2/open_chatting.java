package programmers_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class open_chatting {
    public static void main(String[] args) {
        open_chatting s = new open_chatting();
        String[] record = {"Enter uid1234 Muzi","Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(Arrays.toString(s.solution(record)));
    }

    public String[] solution(String[] record){
        String[] answer = {};
        ArrayList<String> nic = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        for(int i = 0; i<record.length;i++){
            String[] tmp = record[i].split(" ");
            switch (tmp[0]){
                case "Enter" :
                    map.put(tmp[1],tmp[2]);
                    nic.add(tmp[1] + "님이 들어왔습니다.");
                    break;
                case "Leave" :
                    nic.add(tmp[1] + "님이 나갔습니다.");
                    break;
                case "Change":
                    map.put(tmp[1],tmp[2]);
                    break;
            }
        }
        answer = new String[nic.size()];
        for(int i = 0; i< nic.size();i++){
            int cur = nic.get(i).indexOf("님");
            String userId = nic.get(i).substring(0,cur);

            answer[i] = nic.get(i).replace(userId,map.get(userId));
        }

        return answer;
    }

}
