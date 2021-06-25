public class compression_string {
    public static void main(String[] args) {
        compression_string a = new compression_string();
        String s = "aabbaccc";
        System.out.println(a.solution(s));
    }

    public int solution(String s){
        int min = s.length();

        //1~길이의 반으로 단위를 만든다
        for(int i = 1; i<=s.length()/2;i++){
            int com = compression(s,i).length();
            min = Math.min(min,com);
        }
        return min;
    }

    public String compression(String str, int i) {
        int cnt = 1;
        String compression = "";
        String pattern = "";

        for(int j = 0; j<=str.length()+i;j+=i){
            String nowStr;

            // 문자열의 끝이 되어서 더이상 비교할 문자열이 없을 때
            if(j>=str.length()){
                nowStr = "";
            }
            // 문자열이 남아있지만 단위만큼이 안될 때
            else if(str.length() < j+i){
                nowStr = str.substring(j);
            }else{
                nowStr = str.substring(j,j+i);
            }

            if(j != 0){
                if(nowStr.equals(pattern)){
                    cnt++;
                }else if(cnt >=2){
                    compression += cnt + pattern;
                    cnt = 1;
                }else{
                    compression += pattern;
                }
            }
            pattern = nowStr;
        }
        return compression;
    }
}
