package programmers;

public class press_keypad {
    public static void main(String args[]){
        int[] number = {1,3,4,5,8,2,1,4,5,9,5};
        String hand = "right";
        System.out.println(solution(number,hand));
    }
    public static String solution(int[] numbers, String hand){
        String answer ="";
        int left = 10;
        int right = 12;

        for(int i = 0; i< numbers.length;i++){
            if(numbers[i] == 0) numbers[i] = 11;
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                answer+= "L";
                left = numbers[i];
            }else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                answer += "R";
                right = numbers[i];
            }else{
                int[] leftfin = {(left/3), (left%3)};
                int[] rightfin = {(right/3), (right%3)};
                int[] check = {(numbers[i]/3), (numbers[i]%3)};

                if(rightfin[1] == 0){
                    rightfin[0] = rightfin[0] - 1;
                    rightfin[1] = 3;
                }


                int ll = Math.abs(leftfin[1] - check[1]);
                int rr = Math.abs(rightfin[1] - check[1]);

                int lec = Math.abs(leftfin[0] - check[0]) +ll;
                int rec = Math.abs(rightfin[0] - check[0]) + rr;

                if(lec > rec){
                    answer += "R";
                    right = numbers[i];
                }else if(lec < rec){
                    answer += "L";
                    left = numbers[i];
                }else{
                    if(hand.equals("left")){
                        answer += "L";
                        left = numbers[i];
                    }else if(hand.equals("right")){
                        answer += "R";
                        right =numbers[i];
                    }
                }
            }
        }
        return answer;
    }
}
