package programmers_3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class double_priority_queue {
    public static void main(String[] args) {
        String[] operations= {"I 7","I 5","I -5","D -1"};
        double_priority_queue s = new double_priority_queue();
        System.out.println(Arrays.toString(s.solution(operations)));
    }
    public int[] solution(String[] operations){
        int[] answer = {0,0};
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> queue1 = new PriorityQueue<>();

        for (String operation : operations) {
            String[] fir = operation.split(" ");
            if (fir[0].equals("I")) {
                queue.add(Integer.parseInt(fir[1]));
                queue1.add(Integer.parseInt(fir[1]));
            } else {
                if(!queue.isEmpty() && !queue1.isEmpty()) {
                    if (fir[1].equals("1")) {
                        int max = queue.peek();
                        queue.remove(max);
                        queue1.remove(max);
                    } else {
                        int min = queue1.peek();
                        queue.remove(min);
                        queue1.remove(min);
                    }
                }
            }
        }
        if(!queue.isEmpty() && !queue1.isEmpty()) {
            answer[0] = queue.peek();
            answer[1] = queue1.peek();
        }

        return answer;
    }
}
