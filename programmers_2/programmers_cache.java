package programmers_2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class programmers_cache {
    public static void main(String[] args) {
        programmers_cache s =new programmers_cache();
        int cacheSize = 3;
        String[] cities = {"Jeju","Pangyo","Seoul","NewYork","LA","Jeju","Pangyo","Seoul","NewYork","LA"};
        System.out.println(s.solution(cacheSize,cities));
    }
    public int solution(int cacheSize, String[] cities){
        int answer = 0;
        ArrayList<String> array = new ArrayList<>();

        for(int i = 0; i< cities.length;i++) {
            cities[i] = cities[i].toLowerCase();
        }
        if(cacheSize == 0){
            return 5 * cities.length;
        }

        for(int i = 0; i< cities.length;i++){
            if(!array.contains(cities[i])){
                if(array.size()<cacheSize){
                    answer += 5;
                    array.add(cities[i]);
                }else{
                    array.remove(0);
                    array.add(cities[i]);
                    answer += 5;
                }
            }else{
                array.remove(array.indexOf(cities[i]));
                array.add(cities[i]);
                answer += 1;
            }
        }
        return answer;
    }
}
