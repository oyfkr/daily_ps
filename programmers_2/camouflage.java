package programmers_2;

import java.util.HashMap;

public class camouflage {
    public static void main(String[] args) {
        String[][] clothes = {{"yello_hat","headgear"},{"blue_sunglasses","eyewear"},{"aaa","headgear"}};
        camouflage s = new camouflage();
        System.out.println(s.solution(clothes));
    }
    public int solution(String[][] clothes){
        int answer = 1;
        HashMap<String, Integer> hash = new HashMap<>();

        for(int i = 0; i< clothes.length;i++){
            hash.put(clothes[i][1],hash.getOrDefault(clothes[i][1],0)+1);
        }

        for(String key : hash.keySet()){
            answer *= hash.get(key)  + 1;
        }
        return answer -1;
    }
}
