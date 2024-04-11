import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class 두정수사이의합 {
    public long solution(int a, int b) {
        long answer = 0;

        int big = a > b ? a : a < b ? b : -1;
        int small = a < b ? a : a > b ? b : -1;
        
        if(big == -1){
            return a;
        }
       
        for(int i=small; i<=big; i++){
            answer += i;
        }        
        return answer;
    }    


@Test
public void test(){


    두정수사이의합 solution = new 두정수사이의합();

    assertEquals(12, solution.solution(3,5));
    assertEquals(3, solution.solution(3,3));
    assertEquals(12, solution.solution(5,3));        

}


}