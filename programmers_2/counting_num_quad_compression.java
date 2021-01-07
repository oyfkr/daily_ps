package programmers_2;

import java.util.Arrays;

public class counting_num_quad_compression {
    public static void main(String[] args) {
        int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
        counting_num_quad_compression s = new counting_num_quad_compression();
        System.out.println(Arrays.toString(s.solution(arr)));
    }
    int one = 0;
    int zero = 0;
    public int[] solution(int[][] arr){
        int[] answer = new int[2];
        int a = 0;
        int b = 0;
        int len = arr.length;

        quad(arr,a,b,len);
        answer[0] = one;
        answer[1] = zero;
        return answer;
    }
    public void quad(int[][] arr, int a,int b, int len){
        if(len == 1){
            if(arr[a][b] == 0){
                zero++;
            }else{
                one++;
            }
            return;
        }
        int value = arr[a][b];
        boolean flag = true;
        for(int i = a; i<a+len;i++){
            if(flag) {
                for (int j = b; j < b + len; j++) {
                    if (value != arr[i][j]) {
                        flag = false;
                        break;
                    }
                }
            }else{
                break;
            }
        }
        if(flag){
            if(value == 1){
                one++;
            }else{
                zero++;
            }
        }else{
            len = len/2;

            quad(arr,a,b,len);
            quad(arr,a+len,b,len);
            quad(arr,a,b + len,len);
            quad(arr,a+len,b+len,len);
        }
    }
}
