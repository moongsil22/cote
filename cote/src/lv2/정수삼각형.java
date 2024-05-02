package lv2;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class 정수삼각형 {

	boolean isTrue = true;

    public int solution(int[][] triangle) {

		while(isTrue){
			dfs(triangle, 0);
	    }	

		int max = triangle[triangle.length-1][0];
		for (int i=1; i<triangle.length; i++){
			if(triangle[triangle.length-1][i]>max){
				max = triangle[triangle.length-1][i];
			}
		}
        return max;
    }

	void dfs(int[][] triangle, int depth){

		if(triangle.length-1 == depth){
			isTrue = false;	
		
		}
		
		if(isTrue){
			for(int i=0; i<triangle[depth+1].length; i++){
				if(i==0){
					triangle[depth+1][i] = triangle[depth][i] + triangle[depth+1][i];
				}else if(i == triangle[depth+1].length-1 ){
					triangle[depth+1][i] = triangle[depth][i-1] + triangle[depth+1][i];
				}else{
					triangle[depth+1][i] = Math.max(triangle[depth][i-1],triangle[depth][i]) + triangle[depth+1][i];
				}		
			}
			dfs(triangle, depth+1);
		}
	}

    public int solution2(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            triangle[i][0] += triangle[i-1][0];
            triangle[i][i] += triangle[i-1][i-1];
            for (int j = 1; j < i; j++) 
                triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
        }

        return Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
    }	

    @Test
    public void test() {
        정수삼각형 solution = new 정수삼각형();
        assertEquals(30,solution.solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }


}
