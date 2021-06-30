public class compression_string2 {
    public static void main(String[] args) {
        compression_string2 s = new compression_string2();
        String a = "ababcdcdababcdcd";
        System.out.println(s.solution(a));
    }

    public int solution(String s){
        int min = s.length();
        for(int i = 1; i<=s.length()/2;i++){
            int cou = compression(s,i);
            min = Math.min(min,cou);
        }
        return min;
    }

    public int compression(String s, int i){
        int cnt = 1;
        String compression = "";
        String pattern = "";
        String now = "";
        for(int j = 0; j<s.length()+i;j+=i){
            if(j>=s.length()){
                now = "";
            }else if(j+i>s.length()){
                now = s.substring(j);
            }else{
                now = s.substring(j,j+i);
            }
            if(j != 0){
                if(pattern.equals(now)){
                    cnt++;
                }else{
                    if(cnt > 1){
                        compression += (cnt + pattern);
                        cnt = 1;
                    }else{
                        compression += pattern;
                    }
                }
            }
            pattern = now;
        }
        System.out.println(compression);
        return compression.length();
    }
}
