import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class tuple {
    public static void main(String[] args) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        tuple t = new tuple();
        System.out.println(Arrays.toString(t.solution(s)));
    }
    public int[] solution(String s){

        //양 끝의 {}를 제거
        s = s.substring(1);
        s = s.substring(0,s.length()-1);
        s = s.replace("{","");
        String[] tmp = s.split("}");

        for(int i = 0; i<tmp.length;i++){
            if(tmp[i].charAt(0) == ','){
                tmp[i] = tmp[i].substring(1);
            }
        }
        Comparator<String> com = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };

        Arrays.sort(tmp,com);
        ArrayList<String> arr = new ArrayList<>();
        for(String t : tmp){
            String[] as = t.split(",");
            for(String a : as){
                if(!arr.contains(a)){
                    arr.add(a);
                }
            }
        }
        int[] answer = new int[arr.size()];
        for(int i = 0; i<arr.size();i++){
            answer[i] = Integer.parseInt(arr.get(i));
        }

        return answer;
    }
}
