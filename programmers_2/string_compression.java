package programmers_2;

public class string_compression {
    public static void main(String args[]){
        String s = "aabbaccc";
        string_compression a = new string_compression();
        System.out.println(a.solution(s));
    }
    public int solution(String s) {
        int answer = s.length();
        int halflength = s.length() / 2;

        //i 만큼 검사
        for(int i = 1; i <= halflength;i++){
            //aab baccc
            int start = 0;
            int end = start + i;
            int cnt = 1;
            int compression = 0;
            String cur = s.substring(start,end);
            //cur = a
            String next ="";
            //next = a
            start += i;
            end += i;

            while(end <= s.length()){
                next = s.substring(start,end);
                //next = a
                if(!cur.equals(next)){
                    if(cnt>1){
                        compression += (int)(Math.log10(cnt)+1);
                    }
                    compression += cur.length();
                    cnt = 0;
                    cur = next;
                }
                cnt++;
                start +=i;
                end += i;
            }
            end -= i;
            compression += s.substring(end).length();
            if(cnt > 1){
                compression += (int)(Math.log10(cnt)+1);;
            }
            compression += cur.length();

            if(answer > compression){
                answer = compression;
            }
        }
        return answer;
    }
}
