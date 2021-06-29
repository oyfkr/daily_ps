import java.util.*;

public class rank_search {
    public static void main(String[] args) {
        rank_search s = new rank_search();
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        System.out.println(Arrays.toString(s.solution(info,query)));
    }

    static Map<String, ArrayList<Integer>>infoMap = new HashMap<>();
    public int[] solution(String[] info, String[] query){
        int[] answer = new int[query.length];

        //key 만들기
        for(int i = 0; i<info.length;i++){
            makeKey(info[i]);
        }

        //value값들 정렬
        for(Map.Entry<String, ArrayList<Integer>> entry : infoMap.entrySet()){
            Collections.sort(entry.getValue());
        }

        //query부분 처리
        for(int i = 0; i< query.length;i++){
            String[] tmp = query[i].split(" ");
            String key = tmp[0] + tmp[2] +tmp[4] + tmp[6];

            if(!infoMap.containsKey(key)){
                answer[i] = 0;
                continue;
            }
            ArrayList<Integer> arr = infoMap.get(key);
            if(tmp[7].equals("-")){
                answer[i] = arr.size();
            }else{
                int score = Integer.parseInt(tmp[7]);
                answer[i] = binarySearch(arr,score);
            }
        }
        return answer;
    }

    private void makeKey(String info) {
        String[] tmp = info.split(" ");
        String[] language = {tmp[0],"-"};
        String[] part = {tmp[1],"-"};
        String[] career = {tmp[2],"-"};
        String[] food = {tmp[3],"-"};
        int score = Integer.parseInt(tmp[4]);

        for(int i = 0; i< language.length;i++){
            for(int j = 0; j< part.length;j++){
                for(int k = 0; k< career.length;k++){
                    for(int l = 0;l< food.length;l++){
                        String key = language[i] + part[j] + career[k] + food[l];
                        if(infoMap.containsKey(key)){
                            ArrayList<Integer> arr = infoMap.get(key);
                            arr.add(score);
                            infoMap.put(key,arr);
                        }else{
                            ArrayList<Integer> arr = new ArrayList<>();
                            arr.add(score);
                            infoMap.put(key,arr);
                        }
                    }
                }
            }
        }
    }

    public int binarySearch(ArrayList<Integer> arr,int score){
        int mid = 0;
        int end = arr.size();
        int start = 0;

        while(end>start){
            mid = (start+end)/2;
            if(arr.get(mid) >= score){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return arr.size() - start;
    }
}
