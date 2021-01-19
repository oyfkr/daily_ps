package programmers_2;

public class make_primeNum {
    public static void main(String[] args) {
        int []nums = {1,2,7,6,4};
        make_primeNum s = new make_primeNum();
        System.out.println(s.solution(nums));
    }

    public int solution(int[] nums){
        for(int i = 0; i<nums.length;i++){
            for(int j = i+1; j< nums.length;j++){
                for(int k = j+1;k< nums.length;k++){
                    int num = nums[i] + nums[j] + nums[k];
                    primeNum(num);
                }
            }
        }
        return primeSum;
    }
    static int primeSum = 0;


    public static void primeNum(int num){
        int sqrt = (int)Math.sqrt(num);
        if(num == 2){
            primeSum++;
            return;
        }else if(num % 2 == 0|| num==1){
            return;
        }else{
            for(int i = 3; i<=sqrt;i+=2){
                if(num%i == 0){
                    return;
                }
            }
        }
        primeSum++;
    }
}
