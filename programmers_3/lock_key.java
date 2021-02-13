package programmers_2;

public class lock_key {
    public static void main(String[] args) {
        lock_key s = new lock_key();
        int[][] key = {{0,0,0},{1,0,0},{0,1,1}};
        int[][] lock = {{1,1,1},{1,1,0},{1,0,1}};
        System.out.println(s.solution(key,lock));
    }

    public boolean solution(int[][] key, int[][] lock){
        boolean answer = false;
        int[][] newLock = new int[lock.length*3][lock.length*3];
        for(int i = 0;i< lock.length;i++){
            for(int j = 0; j< lock.length;j++){
                newLock[i+ lock.length][j+ lock.length] = lock[i][j];
            }
        }
        for(int i = 0; i<4;i++){
            key = turn(key);

            for(int j = 0; j< lock.length*2;j++){
                for(int k = 0; k< lock.length*2;k++){

                    for(int a = 0; a< key.length;a++){
                        for(int b = 0; b< key.length;b++){
                            newLock[j+a][k+b] += key[a][b];
                        }
                    }
                    if(check(newLock)) return true;

                    for(int a = 0;a< key.length;a++){
                        for(int b = 0; b< key.length;b++){
                            newLock[j+a][k+b] -=key[a][b];
                        }
                    }
                }
            }
        }
        return answer;
    }

    public int[][] turn(int[][] key){
        int[][] tmp = new int[key.length][key[0].length];
        for(int i = 0; i<tmp.length;i++){
            for(int j = 0; j<tmp.length;j++){
                tmp[i][j] = key[key.length-1-j][i];
            }
        }
        return tmp;
    }

    public boolean check(int[][] newLock){
        int cnt = 0;
        int len = newLock.length/3;
        for(int i = len;i<len*2;i++){
            for(int j = len;j<len*2l;j++){
                if(newLock[i][j] == 1) cnt++;
            }
        }
        return cnt == len*len;
    }
}
