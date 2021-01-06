package programmers_2;

public class target_number {
    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        target_number s = new target_number();
        System.out.println(s.solution(numbers,target));
    }
    public int solution(int[] numbers, int target){
        int answer = 0;
        answer = dfs(numbers,target,numbers[0],1) + dfs(numbers,target,-numbers[0],1);
        return answer;
    }
    public int dfs(int[] numbers, int target, int sum, int i){
        if(i == numbers.length){
            if(sum == target){
                return 1;
            }else{
                return 0;
            }
        }
        int result = 0;
        result += dfs(numbers,target,sum+numbers[i],i+1);
        result += dfs(numbers,target,sum- numbers[i],i+1);

        return result;
    }
}
