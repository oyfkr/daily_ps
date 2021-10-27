package programmers;

public class Add_Missing_Num {

    public static void main(String[] args) {
        Add_Missing_Num s = new Add_Missing_Num();

        System.out.println(s.solution(new int[]{1, 2, 3, 4, 6, 7, 8, 0}));
    }

    public int solution(int[] number){
        int answer = 0;

        boolean[] check = new boolean[10];

        for(int n : number){
            check[n] = true;
        }

        for(int i = 0; i<check.length;i++){
            if(!check[i]){
                answer += i;
            }
        }

        return answer;
    }
}
