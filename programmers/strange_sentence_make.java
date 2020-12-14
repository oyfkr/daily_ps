package programmers;

public class strange_sentence_make {
    public static void main(String args[]){
        String s = "try hello world";
        System.out.println(solution(s));
    }
    public static String solution(String s){
        String answer = "";
        String[] array = s.split(" ",-1);
        for(int i = 0; i< array.length;i++){
            for(int j = 0; j<array[i].length();j++){
                if(j % 2 == 0){
                    answer += Character.toUpperCase(array[i].charAt(j));
                }else{
                    answer += Character.toLowerCase(array[i].charAt(j));
                }
            }
            if(i != array.length-1){
                answer += " ";
            }
        }
        return answer;
    }
}
