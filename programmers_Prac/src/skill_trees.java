public class skill_trees {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE","CBADF","AECB","BDA"};
        skill_trees s = new skill_trees();
        System.out.println(s.solution(skill,skill_trees));
    }

    public int solution(String skill,String[] skill_trees){
        int answer = skill_trees.length;

        for(String s : skill_trees){
            int pre = s.indexOf(skill.charAt(0));
            for(int i = 1; i<skill.length();i++){
                int cur = s.indexOf(skill.charAt(i));
                if((pre > cur && cur != -1) || (pre == -1 && cur != -1)){
                    answer--;
                    break;
                }
                pre = cur;
            }
        }
        return answer;
    }
}
