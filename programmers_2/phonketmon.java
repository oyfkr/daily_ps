package programmers_2;

import java.util.HashMap;
import java.util.Map;

public class phonketmon {
    public static void main(String[] args) {
        int num[] ={3,3,3,2,2,2};
        phonketmon s = new phonketmon();
        System.out.println(s.solution(num));
    }
    public int solution(int[] nums){
        int answer = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        /*
        System.out.println(map);
        System.out.println("길이의 반 :" + nums.length/2);
        System.out.println("map의 크기 : " + map.size());
        */
        if(nums.length/2 > map.size()){
            answer = map.size();
        }else{
            answer = nums.length/2;
        }
        return answer;
    }
}
