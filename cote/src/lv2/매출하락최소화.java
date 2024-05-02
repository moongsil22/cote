package lv2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class 매출하락최소화 {

	int[] Sales;
	List<List<Integer>> Children = new ArrayList<>();
	int[][] Cost = new int[300000][2];

	public int solution(int[] sales, int[][] links){
		Sales = sales;
		for(int i=0; i<sales.length; i++){
			Children.add(new ArrayList<>());
		}

		for(int[] link : links){
			Children.get(link[0]-1).add(link[1]-1);
		}
		  
		traversal(0);
 		return Math.min(Cost[0][0],Cost[0][1]);

	}

	void traversal(int node){
		Cost[node][0]=0;
		Cost[node][1]=Sales[node];

		if(Children.get(node).isEmpty()) return;

		//부모참석 하면 자식 참석안해도 상관 없음. 부모 참석 안하면 자식 참석해야함.
		int extraCost = Integer.MAX_VALUE;
		for(int child: Children.get(node)){
			traversal(child);
			if(Cost[child][0] < Cost[child][1]){
				Cost[node][0] += Cost[child][0];
				Cost[node][1] += Cost[child][0];
				extraCost = Math.min(extraCost, Cost[child][1]-Cost[child][0]);

			}else{
				Cost[node][0] += Cost[child][1];
				Cost[node][1] += Cost[child][1];
				extraCost = 0;				
			}
			
		}
        Cost[node][0] += extraCost;
	}



    @Test
    public void test() {
        매출하락최소화 solution = new 매출하락최소화();
        assertEquals(44,solution.solution(new int[]{14, 17, 15, 18, 19, 14, 13, 16, 28, 17},new int[][]{{10, 8}, {1, 9}, {9, 7}, {5, 4}, {1, 5}, {5, 10}, {10, 6}, {1, 3}, {10, 2}}));
    }

    @Test
    public void test2() {
        매출하락최소화 solution = new 매출하락최소화();
		assertEquals(6,solution.solution(new int[]{5, 6, 5, 3, 4},new int[][]{{2,3}, {1,4}, {2,5}, {1,2}}));
    }
	
    @Test
    public void test3() {
        매출하락최소화 solution = new 매출하락최소화();
		assertEquals(5,solution.solution(new int[]{5, 6, 5, 1, 4},new int[][]{{2,3}, {1,4}, {2,5}, {1,2}}));
    }
	
    @Test
    public void test4() {
        매출하락최소화 solution = new 매출하락최소화();
		assertEquals(2,solution.solution(new int[]{10,10,1,1},new int[][]{{3,2}, {4,3}, {1,4}}));
    }	

}
