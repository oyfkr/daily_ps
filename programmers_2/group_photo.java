package programmers_2;

import java.util.Arrays;
import java.util.HashMap;

public class group_photo {
    public static void main(String args[]){
        int n = 2;
        String[] data = {"N~F=0","R~T>2"};
        group_photo s = new group_photo();
        System.out.println(s.solution(n,data));
    }
    HashMap<Character, Integer> map = new HashMap<>();
    int count = 0;
    boolean[] select = new boolean[8];
    int[] array = new int[8];
    public int solution(int n, String[] data){
        map.put('A',0);
        map.put('C',1);
        map.put('F',2);
        map.put('J',3);
        map.put('M',4);
        map.put('N',5);
        map.put('R',6);
        map.put('T',7);

        dfs(0,data);

        return count;
    }
    public void dfs(int pos,String[] data){
        if(pos == 8){
            for(int i = 0; i<data.length;i++){
                int num1 = array[map.get(data[i].charAt(0))];
                int num2 = array[map.get(data[i].charAt(2))];
                char com = data[i].charAt(3);
                int comnum = data[i].charAt(4)-'0';
                int num3 = Math.abs(num1-num2)-1;

                if(com == '='){
                    if(num3 !=comnum){
                        return;
                    }
                }else if(com == '>'){
                    if(num3 <= comnum){
                        return;
                    }
                }else{
                    if(num3 >= comnum){
                        return;
                    }
                }
            }
            count++;
            return;
        }

        for(int i = 0; i < 8;i++){
            if(!select[i]){
                select[i] = true;
                array[pos] = i;
                dfs(pos+1,data);
                select[i] = false;
            }
        }
    }
}
