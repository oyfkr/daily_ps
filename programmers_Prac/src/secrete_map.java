import java.util.Arrays;

public class secrete_map {
    public static void main(String[] args) {
        secrete_map s = new secrete_map();
        int n = 6;
        int[] arr1 = {46,33,33,22,31,50};
        int[] arr2 = {27,56,19,14,14,1};
        System.out.println(Arrays.toString(s.solution(n, arr1, arr2)));
    }

    public String[] solution(int n,int[] arr1,int[] arr2){
        String[] answer = new String[n];
        String arr1_two ="";
        String arr2_two ="";
        for(int i = 0; i<n;i++) {
            arr1_two = Integer.toBinaryString(arr1[i]);
            arr2_two = Integer.toBinaryString(arr2[i]);

            while (arr1_two.length() < n || arr2_two.length() < n) {
                if (arr1_two.length() < n) {
                    arr1_two = "0" + arr1_two;
                }
                if(arr2_two.length() <n){
                    arr2_two = "0" + arr2_two;
                }
            }
            String tmp ="";
            for(int j = 0; j<n;j++){
                if(arr1_two.charAt(j) == '0' && arr2_two.charAt(j)=='0'){
                    tmp +=" ";
                }else{
                    tmp +="#";
                }
            }
            answer[i] = tmp;
        }
        return answer;
    }
}
