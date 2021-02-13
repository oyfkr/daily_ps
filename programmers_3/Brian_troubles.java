package programmers_2;

import java.util.ArrayList;

public class Brian_troubles {
    public static void main(String[] args) {
        Brian_troubles s = new Brian_troubles();
        String sentence = "HaEaLaLaObWORLDb";
        System.out.println(s.solution(sentence));
    }
    public String solution(String sentence){
        String answer ="";
        ArrayList<String> array = new ArrayList<>();
        char ch;
        while(sentence.length() >0){
            if(sentence.length()<3) return "invalid";

            if(firche(sentence,0)){
                ch = sentence.charAt(0);
                int tmp=0;
                for(int i = 1; i<sentence.length();i++){
                    if(sentence.charAt(i) == ch){
                        tmp = i;
                        break;
                    }
                }
                if(tmp ==0) return "invalid";
                array.add(sentence.substring(0,tmp+1));
                sentence = sentence.substring(tmp+1);
            }else{
                if(!firche(sentence,1)) return "invalid";
                ch = sentence.charAt(1);

                int tmp = 0;
                for(int i = 2; i<sentence.length();i++){
                    if(firche(sentence,i)){
                        tmp = i;
                        if(sentence.charAt(i) != ch) break;
                    }
                }
                if(tmp == 0) return "invalid";

                while(tmp >=1){
                    if(ch == sentence.charAt(tmp)) break;
                    tmp--;
                }
                array.add(sentence.substring(0,tmp+2));
                sentence = sentence.substring(tmp+2);
            }
        }
        for(String s : array){
            answer += disapper(s) + " ";
        }

        return answer.trim();
    }

    public boolean firche(String str, int i){
        if(str.charAt(i) >= 'a' && str.charAt(i)<='z')return true;
        return false;
    }
    public String disapper(String s){
        if(firche(s,0)) s = s.replace(s.charAt(0),' ');
        if(firche(s,1)) s = s.replace(s.charAt(1),' ');

        s=s.replace(" ", "");
        return s;
    }
}
