package programmers_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class tuple {
    public static void main(String[] args) {
        tuple a = new tuple();
        String s = "{{123}}";
        System.out.println(Arrays.toString(a.solution(s)));
    }
    public int[] solution(String s){
        int[] answer = {};

        //가장 끝에 있는 대괄호 제거
        s = s.substring(1,s.length()-1);

        //가장 끝 대괄호 제거 후 { 제거
        s = s.replace("{","");

        //}를 기준으로 문자열 쪼개서 문자배열에 넣기
        String[] arr = s.split("}");
        for(int i = 0; i<arr.length;i++){
            if(arr[i].charAt(0) == ','){
                //두번째 문자열부터 맨앞에,를 제거
                arr[i] = arr[i].substring(1,arr[i].length());
            }
        }

        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(),o2.length());
            }
        };
        Arrays.sort(arr,comp);
        ArrayList<String> tmp = new ArrayList<>();
        for(int i = 0; i< arr.length;i++){
            String[] a = arr[i].split(",");
            for(int j = 0; j<a.length;j++){
                if(!tmp.contains(a[j])){
                    tmp.add(a[j]);
                }
            }
        }
        answer = new int[tmp.size()];
        for(int i = 0; i<tmp.size();i++){
            answer[i] = Integer.parseInt(tmp.get(i));
        }
        return answer;
    }
}
