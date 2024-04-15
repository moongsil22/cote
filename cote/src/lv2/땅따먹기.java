package lv2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// 0은 벽 1은 벽아님. 1으로지나갈수 있다.

public class 땅따먹기 {

    int solution(int[][] land) {
        int answer = 0;

        for(int i=1; i< land.length; i++){
            land[i][0] +=Math.max(land[i-1][1],Math.max(land[i-1][2],land[i-1][3]));
            land[i][1] +=Math.max(land[i-1][0],Math.max(land[i-1][2],land[i-1][3]));
            land[i][2] +=Math.max(land[i-1][0],Math.max(land[i-1][1],land[i-1][3]));
            land[i][3] +=Math.max(land[i-1][0],Math.max(land[i-1][1],land[i-1][2]));
        }

        for(int i=0; i<4; i++){
            answer = Math.max(answer, land[land.length-1][i]);
        }

        return answer;
    }


    int solution2(int[][] land){

        return hopscotch(land, land.length);
    }

    int hopscotch(int[][] board, int size){
        return hopscotch(board,size,0,-1);
    }


    private int hopscotch(int[][] board, int size, int y, int idx){
        if(y >=size) return 0;
        int answer = Integer.MIN_VALUE;
        for(int i=0; i<4; i++){
            if(i !=idx){
                answer = Math.max(hopscotch(board, size,y+1,i)+ board[y][i], answer);
            }
        }
        
        return answer;
    }

    @Test
    public void test(){
        땅따먹기 solution = new 땅따먹기();

        assertEquals(16,solution.solution(new int[][]{{1,2,3,5},{5,6,7,8},{4,3,2,1}}) );
    }

    @Test
    public void test2(){
        땅따먹기 solution = new 땅따먹기();

        assertEquals(16,solution.solution2(new int[][]{{1,2,3,5},{5,6,7,8},{4,3,2,1}}) );
    }

}
