public class traffic_chu {
    public static void main(String[] args) {
        traffic_chu s = new traffic_chu();
        String[] lines = {"2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"};
        System.out.println(s.solution(lines));
    }

    public int solution(String[] lines){
        int answer = 0;
        int cnt = 1;
        int[] arr = new int[lines.length];

        for(int i = 0; i< lines.length;i++){
            lines[i] = lines[i].substring(11).replace(":","").replace("s","");
            int sec = Integer.parseInt(lines[i].substring(0,2))*3600 + Integer.parseInt(lines[i].substring(2,4)) * 60 + Integer.parseInt(lines[i].substring(4,6));
            lines[i] = "" + sec + lines[i].substring(6);
        }

        /*
        for(String s : lines){
            System.out.println(s);
        }

         */

        double complete;
        double area;
        for(int i=0; i<lines.length;i++){
            complete = Double.parseDouble(lines[i].split(" ")[0]);
            area = complete +1;

            for(int j = i+1;j< lines.length;j++){
                double start = Double.parseDouble(lines[j].split(" ")[0]) - Double.parseDouble(lines[j].split(" ")[1])+0.001;
                if(start < area){
                    cnt++;
                }
            }
            arr[i] = cnt;
            cnt = 1;
        }
        for(int a : arr){
            answer = Math.max(answer,a);
        }

        return answer;
    }
}
