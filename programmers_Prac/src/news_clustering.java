import java.util.ArrayList;
import java.util.Collections;

public class news_clustering {
    public static void main(String[] args) {
        news_clustering s = new news_clustering();
        String str1 = "FRANCE";
        String str2 = "french";
        System.out.println(s.solution(str1,str2));
    }

    public int solution(String str1, String str2){
        int answer = 0;

        ArrayList<String> arr1 = new ArrayList<>();
        ArrayList<String> arr2 = new ArrayList<>();
        ArrayList<String> gong = new ArrayList<>();
        ArrayList<String> hab = new ArrayList<>();

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        for(int i = 0; i<str1.length()-1;i++){
            char first = str1.charAt(i);
            char second = str1.charAt(i+1);
            if(first >='a' && first <='z' && second >='a' && second <='z'){
                arr1.add(first +""+second);
            }
        }

        for(int i = 0; i<str2.length()-1;i++){
            char first = str2.charAt(i);
            char second = str2.charAt(i+1);
            if(first >='a' && first <='z' && second >='a' && second <='z'){
                arr2.add(first +""+second);
            }
        }

        for(String s : arr1){
            if(arr2.remove(s)){
                gong.add(s);
            }
            hab.add(s);
        }

        hab.addAll(arr2);

        double gong_len = gong.size();
        double hab_len = hab.size();
        if(hab_len == 0){
            return 65536;
        }
        answer = (int)(gong_len/hab_len* 65536) ;

        return answer;
    }
}
