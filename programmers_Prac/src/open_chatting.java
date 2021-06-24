import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class open_chatting {
    public static void main(String[] args) {
        open_chatting s = new open_chatting();
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(Arrays.toString(s.solution(record)));
    }

    public String[] solution(String[] record){
        HashMap<String, String> map = new HashMap<>();
        ArrayList<String> array = new ArrayList<>();
        for(String s : record){
            String[] tmp = s.split(" ");
            if(tmp[0].equals("Enter")) {
                map.put(tmp[1], tmp[2]);
                array.add(tmp[1] + "님이 들어왔습니다.");
            }else if(tmp[0].equals("Leave")){
                array.add(tmp[1] + "님이 나갔습니다.");
            }else{
                map.put(tmp[1],tmp[2]);
            }
        }
        String[] answer = new String[array.size()];

        for(int i = 0; i<array.size();i++){
            String[] tmp = array.get(i).split("님");
            String id = tmp[0];
            String nic = map.get(id);
            String fin = nic + "님" + tmp[1];
            answer[i] = fin;
        }



        return answer;
    }
}
