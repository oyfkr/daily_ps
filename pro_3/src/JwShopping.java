import java.util.*;

public class JwShopping {
    public static void main(String[] args) {
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        JwShopping j = new JwShopping();
        System.out.println(Arrays.toString(j.solution(gems)));
    }

    public int[] solution(String[] gems){

        /**
         * HashSet을 이용하여 중복을 허용하지 않고 보석의 종류를 구한다
         * HashMap을 이용하여 보석의 종류와 개수를 구한다. ex) (DIA, 3), (RUBY, 2) .....
         * Queue를 이용하여 보석의 종류가 다있는지 확인한다.
         */

        HashSet<String> hs = new HashSet<>();
        HashMap<String,Integer> hm = new HashMap<>();
        Queue<String> q = new LinkedList<>();

        // 보석의 종류를 넣는다.
        Collections.addAll(hs, gems);

        int start = 0;
        int next = 0;
        int len = gems.length;
        for(String gem : gems){
            // 보석을 큐에 넣고 hashmap에도 넣는다
            // hashmap에 넣을 때 하나도 없으면 1, 1개가 있다면 1씩 더해준다.
            q.add(gem);
            hm.put(gem,hm.getOrDefault(gem,0)+1);

            // 큐의 값을 확인하고 hashmap에 2이상이면 큐에서 값을 뽑아내고 hashmap에서도 값을 하나 뺀다.
            // 큐에서 값이 사라지는 것은 그 자리를 넘어가도 상관없다는 뜻이므로 시작점을 1더해준다.
            while (true){
                String tmp = q.peek();
                if(hm.get(tmp)>1){
                    q.poll();
                    hm.put(tmp,hm.get(tmp)-1);
                    next++;
                }else{
                    break;
                }
            }
            // hashmap과 hashset의 사이즈가 같고 큐의 길이가 더 작으면 시작점을 바꿔주고 len을 큐의 사이즈로 바꿔준다.
            if(hm.size() == hs.size()){
                if(len > q.size()){
                    len = q.size();
                    start = next;
                }
            }
        }


        return new int[]{start+1, start+len};
    }
}
