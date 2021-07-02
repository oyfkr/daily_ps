public class joystick {
    public static void main(String[] args) {
        String name = "AAABBAAAB";
        joystick s = new joystick();
        System.out.println(s.solution(name));
    }
    public int solution(String name){
        int answer = 0;

        int move_min = name.length()-1;

        for(int i = 0; i<name.length();i++){
            answer += Math.min(name.charAt(i) - 'A','Z'-name.charAt(i)+1);

            int len = i+1;
            while(len < name.length() && name.charAt(len) == 'A'){
                len++;
            }
            move_min = Math.min(move_min,i*2 +name.length()-len);
        }
        answer += move_min;

        return answer;
    }
}
