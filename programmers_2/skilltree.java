package programmers_2;

import java.util.ArrayList;

public class skilltree {
    public static void main(String args[]){
        String skill = "CBD";
        String[] skill_trees = {"AAAA","CBD","DC"};
        System.out.println(solution(skill,skill_trees));
    }
    public static int solution(String skill, String[] skill_trees){
        int answer = skill_trees.length;
        int preindex=0;
        int curindex=0;
        for(int i = 0; i< skill_trees.length;i++){
            preindex = skill_trees[i].indexOf(skill.charAt(0));

            for(int j = 1; j<skill.length();j++){
                curindex = skill_trees[i].indexOf(skill.charAt(j));
                //ex) BCD -> ADCB  || BDC -> DC
                if((preindex > curindex && curindex != -1) || (preindex == -1 && curindex != -1)){
                    answer--;
                    break;
                }
                preindex = curindex;
            }

        }
        return answer;
    }
}
