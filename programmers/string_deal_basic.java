package programmers;

public class string_deal_basic {
    public static void main(String args[]) {
        String s = "1234";
        System.out.println(solution(s));
    }

    public static boolean solution(String s) {
        boolean answer = true;
        if (s.length() == 4 || s.length() == 6) {
            int[] tmp = new int[s.length()];
            for (int i = 0; i < s.length(); i++) {
                tmp[i] = s.charAt(i);
            }

            for (int i = 0; i < tmp.length; i++) {
                if (tmp[i] >= 48 && tmp[i] <= 57) {
                    answer = true;

                } else {
                    answer = false;
                    break;
                }
                ;
            }

            return answer;
        }
        else answer = false;
        return answer;
    }

}
