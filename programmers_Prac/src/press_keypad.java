public class press_keypad {
    public static void main(String[] args) {
        press_keypad s = new press_keypad();
        int[] numbers = {1,3,4,5,8,2,1,4,5,9,5};
        String hand = "right";
        System.out.println(s.soluton(numbers,hand));
    }
    public String soluton(int[] numbers,String hand){
        String answer = "";
        int left = 10;
        int right = 12;
        int left1=0;
        int left2=0;
        int right1=0;
        int right2=0;
        int number1 = 0;
        int number2 = 0;
        int leftlen = 0;
        int rightlen = 0;

        for(int number : numbers){
            if(number == 1 || number == 4 || number == 7){
                left = number;
                answer +="L";
            }else if(number == 3 || number == 6 || number == 9){
                right = number;
                answer += "R";
            }else{
                left = (left ==0) ? 11 : left;
                right = (right == 0) ? 11 : right;
                number = (number == 0)? 11 : number;

                left1 = (left-1)/3;
                left2 = (left-1)%3;

                right1 = (right-1)/3;
                right2 = (right-1)%3;

                number1 = (number-1)/3;
                number2 = (number-1)%3;

                leftlen = Math.abs(left1-number1) + Math.abs(left2-number2);
                rightlen = Math.abs(right1-number1) + Math.abs(right2-number2);

                if(leftlen > rightlen){
                    answer += "R";
                    right = number;
                }else if(leftlen<rightlen){
                    answer +="L";
                    left = number;
                }else {
                    if(hand.equals("right")){
                        answer +="R";
                        right = number;
                    }else{
                        answer += "L";
                        left = number;
                    }
                }
            }
        }

        return answer;
    }
}
