package programmers_2;

import java.util.Arrays;

public class kakao_colorbook {
    public static void main(String args[]){
        int m = 6;
        int n = 4;
        int[][] picture = {{1,1,1,0},{1,2,2,0},{1,0,0,1},{0,0,0,1},{0,0,0,3},{0,0,0,3}};
        System.out.println(Arrays.toString(solution(m,n,picture)));
    }
    public static int[] solution(int m, int n, int[][] picture){
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        //확인했는지 알기 위한 이중배열
        int[][] isViewd = new int[picture.length][picture[0].length];
        int[] answer = new int[2];
        //picture의 원소 하나하나를 찾아본다
        for(int i = 0; i< picture.length;i++){
            for(int j = 0; j<picture[0].length;j++){
                int area = area(picture,isViewd,i,j);
                if(area >0){
                    numberOfArea++;
                    maxSizeOfOneArea = maxSizeOfOneArea < area ? area : maxSizeOfOneArea;
                }
            }
        }
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static int area(int[][] picture,int[][] isViewd, int i, int j){
        //원소에 0 일경우
        if(picture[i][j] == 0){
            return 0;
        }
        //이미 검색했던 곳인지 확인
        if(isViewd[i][j]++ > 0){
            return 0;
        }
        int result = 1;
        //i의 1더한 곳이 행의 끝이 아니고 다음 행과 같은 열의 값이 같으면 재귀함수를 이용
        if(i+1 != picture.length){
            if(picture[i+1][j] == picture[i][j]){
                result += area(picture,isViewd,i+1,j);
            }
        }
        if(j+1 != picture[0].length){
            if(picture[i][j+1] == picture[i][j]){
                result += area(picture,isViewd,i,j+1);
            }
        }
        if(i-1 >= 0){
            if(picture[i-1][j] == picture[i][j]){
                result += area(picture,isViewd,i-1,j);
            }
        }
        if(j-1 >=0){
            if(picture[i][j-1] == picture[i][j]){
                result += area(picture,isViewd,i,j-1);
            }
        }
        return result;
    }
}
