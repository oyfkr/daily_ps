package programmers_2;

public class joystick {
    public static void main(String args[]){
        String name = "BAABAAA";
        joystick s = new joystick();
        System.out.println(s.solution(name));
    }
    public int solution(String name){
        int answer = 0;

        int min = name.length()-1; //6

        for(int i = 0; i<name.length();i++){
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            int next = i+1;
            while(next < name.length() && name.charAt(next) == 'A'){
                next++;
            }
            min = Math.min(2*i + name.length()-next,min);
        }
        System.out.println(min);
        return answer + min;
    }
}
