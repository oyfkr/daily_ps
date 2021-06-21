public class new_id_recommend {
    public static void main(String[] args) {
        new_id_recommend s = new new_id_recommend();
        String new_id = "=.=";
        System.out.println(s.solution(new_id));
    }

    public String solution(String new_id){

        //1단계
        String one = new_id.toLowerCase();

        //2단계
        char[] tmp = one.toCharArray();
        String two = "";
        for(char c : tmp){
            if((c>='a' && c<='z') || (c >='0' && c<='9') || c=='-' || c=='_' || c == '.'){
                two += c;
            }
        }

        //3단계
        String three = two;
        while(three.contains("..")){
            three = three.replace("..",".");
        }

        //4단계
        String four = three;
        if(four.length() >0) {
            if (four.charAt(0) == '.') {
                four = four.substring(1);
            }
        }
        if(four.length() > 0) {
            if (three.charAt(three.length() - 1) == '.') {
                four = four.substring(0, four.length() - 1);
            }
        }

        //5단계
        String five = four;
        if(five.equals("")){
            five = "a";
        }

        //6단계
        String six = five;
        if(six.length()>=16){
            six = six.substring(0,15);
        }
        if(six.charAt(six.length()-1) =='.'){
            six = six.substring(0,six.length()-1);
        }

        //7단계
        String seven = six;
        if(seven.length()<=2){
            char tmp1 = seven.charAt(seven.length()-1);
            while (seven.length()<3){
                seven+=tmp1;
            }
        }

        return seven;
    }
}
