package programmers;

public class dart_game {
    public static void main(String args[]){
        String dartResult = "1S2D*3T";
        System.out.println(solution(dartResult));
    }
    public static int solution(String dartResult){
        int answer = 0;
        int[] score = new int[3];
        int index =0, cnt = 0;
        for(int i =0; i<dartResult.length();i++){
            char dartChar = dartResult.charAt(i);
            int dartint = Character.getNumericValue(dartChar);

            if(dartint >= 0 && dartint <=10){
                if(dartint == 1){
                    if(Character.getNumericValue(dartResult.charAt(i+1)) == 0){
                        dartint = 10;
                        i++;
                    }
                }
                score[index] = dartint;
                cnt++;
            }else{
                switch (dartChar){
                    case 'S':
                        score[index] = (int)Math.pow(score[index],1);
                        index++;
                        break;
                    case 'D':
                        score[index] = (int)Math.pow(score[index],2);
                        index++;
                        break;
                    case 'T':
                        score[index] = (int)Math.pow(score[index],3);
                        index++;
                        break;
                    case '*':
                        index = index -2 < 0 ? 0 : index -2;
                        while(index < cnt){
                            score[index] = score[index] * 2;
                            index++;
                        }
                        break;
                    case '#':
                        score[index-1] = score[index-1] * (-1);
                        break;
                }
            }
        }

        return score[0] + score[1] + score[2];
    }
}
