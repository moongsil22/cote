import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class 예산 {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int result = 0;
        Arrays.sort(d);
        for(int i=0; i<d.length; i++){
            result+=d[i] ;
            if(result > budget){
                answer = i;
                break;
            }       
        }
        if(result <= budget){
            answer= d.length;
        }
       return answer;
    }

    public int solution2(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for(int i=0; i<d.length; i++){
            budget-=d[i] ;
            if(budget<0){
                break;
            }
            answer++;
        }
       return answer;
    }

@Test
public void test(){


    예산 solution = new 예산();

    assertEquals(3, solution.solution(new int[] {1,3,2,5,4}, 9));
    assertEquals(4, solution.solution(new int[] {2,2,3,3}, 10));
    assertEquals(3, solution.solution(new int[] {10,2,2}, 100));
    assertEquals(4, solution.solution(new int[] {1,2,3,4,5,6,7,1}, 7));

}

@Test
public void test2(){


    예산 solution = new 예산();

    assertEquals(3, solution.solution2(new int[] {1,3,2,5,4}, 9));
    assertEquals(4, solution.solution2(new int[] {2,2,3,3}, 10));

}


}