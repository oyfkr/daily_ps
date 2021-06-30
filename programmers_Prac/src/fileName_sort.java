import java.util.Arrays;
import java.util.Comparator;

public class fileName_sort {
    public static void main(String[] args) {
        fileName_sort s = new fileName_sort();
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        System.out.println(Arrays.toString(s.solution(files)));
    }

    public String[] solution(String[] files){
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String h1 = o1.split("[0-9]")[0];
                String h2 = o2.split("[0-9]")[0];

                int result = h1.toLowerCase().compareTo(h2.toLowerCase());

                if(result == 0){
                    result = findNum(o1,h1) - findNum(o2,h2);
                }

                return result;
            }
        });
        return files;
    }

    private int findNum(String s, String h) {
        s = s.replace(h,"");
        String result = "";
        for(char c : s.toCharArray()){
            if(Character.isDigit(c) && result.length()<5){
                result += c;
            }else {
                break;
            }
        }
        return Integer.valueOf(result);
    }


}
