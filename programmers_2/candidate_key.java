package programmers_2;

import java.util.ArrayList;
import java.util.HashSet;

public class candidate_key {
    public static void main(String[] args) {
        candidate_key s = new candidate_key();
        String[][] relation = {{"100","rian","music","2"},{"200","apeach","math","2"}
                ,{"300","tube","computer","3",},{"400","con","computer","4"},
                {"500","muzi","music","3"},{"600","apeach","music","2"}};
        System.out.println(s.solution(relation));
    }

    static ArrayList<HashSet<Integer>> candidate;
    public int solution(String[][] relation){
        candidate = new ArrayList<HashSet<Integer>>();
        select(0,new HashSet<Integer>(), relation);

        return candidate.size();
    }


    static void select(int pos, HashSet<Integer> selects, String[][] relation){
        if(pos == relation[0].length){
            for(int i =0 ;i<candidate.size();i++){
                if(selects.containsAll(candidate.get(i))){
                    return;
                }
            }
            HashSet<String> sets = new HashSet<>();
            for(int row = 0; row< relation.length;row++){
                String tmp = "";
                for(int col : selects){
                    tmp += relation[row][col] + ",";
                }
                if(sets.contains(tmp)){
                    return;
                }
                sets.add(tmp);
            }
            candidate.add(selects);
            return;
        }
        HashSet<Integer> copy = new HashSet<>();
        HashSet<Integer> copy2 = new HashSet<>();
        for(Integer value : selects){
            copy.add(value);
            copy2.add(value);
        }

        select(pos+1,copy2,relation);
        copy.add(pos);
        select(pos+1,copy,relation);
    }
}
