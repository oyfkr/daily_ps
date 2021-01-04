package programmers_2;

public class phonenum_list {
    public static void main(String args[]){
        String[] phone_number = {"12","123","1235","567","88"};
        phonenum_list s = new phonenum_list();
        System.out.println(s.solution(phone_number));
    }
    public boolean solution(String[] phone_book){
        boolean answer = true;
        for(int i = 0; i< phone_book.length-1;i++){
            for(int j = i+1; j< phone_book.length;j++){
                if(phone_book[i].startsWith(phone_book[j])) return false;
                if(phone_book[j].startsWith(phone_book[i])) return false;
            }
        }
        return answer;
    }
}
