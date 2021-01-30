package programmers_2;

public class just_now_song {
    public static void main(String[] args) {
        just_now_song s = new just_now_song();
        String m = "ABCDEFG";
        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB","13:00,13:05,WORLD,ABCDEF"};
        System.out.println(s.solution(m,musicinfos));
    }
    public String solution(String m,String[] musicinfos){
        String answer = "(None)";
        int maxtime = 0;
        for(int i = 0; i<m.length();i++){
            m = m.replace("A#","a");
            m = m.replace("C#","c");
            m = m.replace("D#","d");
            m = m.replace("F#","f");
            m = m.replace("G#","g");
            m = m.replace("E#","e");
        }

        for(int i = 0; i< musicinfos.length;i++) {
            String[] tmp = musicinfos[i].split(",");

            tmp[3] = tmp[3].replace("A#","a");
            tmp[3] = tmp[3].replace("C#","c");
            tmp[3] = tmp[3].replace("D#","d");
            tmp[3] = tmp[3].replace("F#","f");
            tmp[3] = tmp[3].replace("G#","g");
            tmp[3] = tmp[3].replace("E#","e");
            

            String[] starttime = tmp[0].split(":");
            String[] endtime = tmp[1].split(":");

            int hour = Integer.parseInt(endtime[0]) - Integer.parseInt(starttime[0]);
            int min = Integer.parseInt(endtime[1]) - Integer.parseInt(starttime[1]) + (hour * 60);

            String meltmp = "";
            for(int j = 0; j<min;j++){
                meltmp += tmp[3].charAt(j%tmp[3].length());
            }
            System.out.println(meltmp);
            if(meltmp.contains(m)){
                if(maxtime < meltmp.length()){
                    maxtime = meltmp.length();
                    answer = tmp[2];
                }
            }
        }
        return answer;
    }
}
