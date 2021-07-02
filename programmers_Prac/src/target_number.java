public class target_number {
    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        target_number s = new target_number();
        System.out.println(s.solution(numbers,target));
    }

    static boolean[] visit;
    static int cnt = 0;
    public int solution(int[] numbers,int target){
        visit = new boolean[numbers.length];
        dfs(0,numbers,target,0);
        return cnt;
    }
    public void dfs(int cur,int[] numbers,int target,int now){
        if(cur == numbers.length){
            if(now == target){
                cnt++;
            }
            return;
        }
        dfs(cur+1,numbers,target,now +numbers[cur]);
        dfs(cur+1,numbers,target,now - numbers[cur]);

    }
}
