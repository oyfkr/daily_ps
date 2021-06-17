public class make_primaryNumber {
    public static void main(String[] args) {
        make_primaryNumber s = new make_primaryNumber();
        int[] nums = {1,2,3,4};
        System.out.println(s.solution(nums));
    }

    public int solution(int[] nums){
        int answer = 0;
        boolean flag = false;
        for(int i = 0; i< nums.length; i++){
            for(int j = i+1; j< nums.length;j++){
                for(int k = j+1;k<nums.length;k++){
                    int num = nums[i] + nums[j] + nums[k];
                    if(num >=2){
                        flag = check(num);
                    }
                    if(flag){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
    public static boolean check(int num){
        if(num == 2){
            return true;
        }
        for(int i = 2; i<num;i++){
            if(num %i == 0){
                return false;
            }
        }
        return true;
    }
}
