public class find_kim {
    public static void main(String[] args) {
        String[] seoul = {"Jane","Kim"};
        find_kim s = new find_kim();
        System.out.println(s.solution(seoul));
    }
    public String solution(String[] seoul){
        String answer = "";
        for(int i = 0; i< seoul.length;i++){
            if(seoul[i].equals("Kim")){
                answer = "김서방은 " + i +"에 있다";
            }
        }
        return answer;
    }
}
