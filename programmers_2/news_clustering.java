package programmers_2;

import java.util.ArrayList;

public class news_clustering {
    public static void main(String[] args) {
        news_clustering s = new news_clustering();
        String str1 = "aa1+aa2";
        String str2 = "AAAA12";
        System.out.println(s.solution(str1,str2));
    }
    public  int solution(String str1, String str2){
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        int sum = 0;

        ArrayList<String> arr1 = new ArrayList<>();
        ArrayList<String> arr2 = new ArrayList<>();
        ArrayList<String> arr3 = new ArrayList<>();
        int i = 0;
        while(i < str1.length()-1){
            if(str1.charAt(i) >='a' && str1.charAt(i)<='z' && str1.charAt(i+1) >='a' && str1.charAt(i+1)<='z') {
                arr1.add(str1.substring(i, i + 2));
            }
            i++;
        }
        i =0;
        while(i < str2.length() -1){
            if(str2.charAt(i) >='a' && str2.charAt(i)<='z' && str2.charAt(i+1) >='a' && str2.charAt(i+1)<='z') {
                arr2.add(str2.substring(i, i + 2));
            }
            i++;
        }
        for(int j = 0; j<arr1.size();j++) {
            if(arr2.contains(arr1.get(j))){
                arr2.remove(arr1.get(j));
                arr3.add(arr1.get(j));
            }
        }
        if(arr1.size() == 0 && arr2.size() ==0){
            return 65536;
        }
        sum = arr1.size() + arr2.size();
        answer = (int)((double) arr3.size()/(double)sum*65536);

        return answer;
    }
}
