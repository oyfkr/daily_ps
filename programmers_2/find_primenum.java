package programmers_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class find_primenum {
    private ArrayList<String> set = new ArrayList<>();
    private int count;

    public static void main(String args[]){
        String number ="011";
        find_primenum s = new find_primenum();
        System.out.println(s.solution(number));

    }
    public int solution(String numbers){
        int size = numbers.length();

        List<Character> arr = new ArrayList<>();
        for(int i = 0; i< size; i++){
            arr.add(numbers.charAt(i));
        }
        List<Character> result = new ArrayList<>();

        //nPr에서 r을 계속 늘리는 반복문 i = r
        for(int i = 0; i< size; i++){
            permutation(arr,result,size,i+1);
        }
        return count;
    }

    // 소수를 판별하는 클래스
    private boolean isPrime(int n){
        int sqrt = (int)Math.sqrt(n);

        if(n == 2){
            return true;
        }
        if(n % 2 == 0 || n ==1){
            return false;
        }
        for(int i = 3; i<=sqrt; i+=2){
            if(n %i == 0){
                return false;
            }
        }
        return true;
    }
    // 재귀를 이용하여 숫자들을 조합하는 클래스
    public void permutation(List<Character> arr,List<Character> result, int n, int r){
        if(r == 0){
            if(result.get(0) != '0'){
                String str = "";
                int size = result.size();
                for(int i = 0; i< size; i++){
                    str += result.get(i);
                }
                //System.out.println(str);
                int num = 0;

                if(!set.contains(str)){
                    num = Integer.parseInt(str);
                    set.add(str);
                    System.out.println(num);
                    if(isPrime(num)){
                        count++;
                    }
                }
            }
            return;
        }
        for(int i = 0; i<n; i++){
            result.add(arr.remove(i));
            //n = 주어진 숫자의 개수, r은 뽑는 숫자
            permutation(arr,result,n-1,r-1);
            arr.add(i,result.remove(result.size()-1));
        }
    }
}
