import java.util.Arrays;
import java.util.HashMap;

public class group_photo {
    public static void main(String[] args) {
        int n = 2;
        String[] data = {"N~F=0","R~T>2"};
        group_photo s = new group_photo();
        System.out.println(s.solution(n,data));
    }

    static int answer;
    static HashMap<Character,Integer> map;
    static boolean[] visit;
    static int[] ch;
    static String[] d;

    public int solution(int n, String[] data){
        d = data;
        map = new HashMap<>();
        ch = new int[8];
        visit = new boolean[8];
        answer = 0;
        map.put('A',0);
        map.put('C',1);
        map.put('F',2);
        map.put('J',3);
        map.put('M',4);
        map.put('N',5);
        map.put('R',6);
        map.put('T',7);
        dfs(0);

        return answer;
    }

    //dfs를 이용하여 모든 줄을 만든다
    public static void dfs(int index){
        if(index == 8){
            if(check()) answer++;
        }
        else{
            for(int i = 0; i<8;i++){
                if(!visit[i]){
                    visit[i] = true;
                    ch[index] = i;
                    dfs(index+1);
                    visit[i] = false;
                }
            }
        }
    }

    //check메소드를 이용하여 조건에 맞는지 확인한다.
    private static boolean check() {
        int a,b,res;
        char op;
        for(String s : d){
            a = ch[map.get(s.charAt(0))];
            b = ch[map.get(s.charAt(2))];
            op = s.charAt(3);
            res = s.charAt(4) -'0' + 1;

            if(op =='=') {
                if (Math.abs(a - b) != res) {
                    return false;
                }
            }
            else if(op == '>'){
                if(Math.abs(a-b) <= res) return false;
            }else{
                if(Math.abs(a-b) >= res) return false;
            }

        }
        return true;
    }
}
