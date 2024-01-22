import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestSolution {
  
  
  @Test
  public void test1(){

    Solution_역순정렬 solution = new Solution_역순정렬();


   assertEquals(87321, solution.solution(17832));
   assertEquals(87322, solution.solution(17832));
   assertEquals(87321, solution.solution(17832));

  }

  @Test
  public void test2(){

    Solution_약수의합 solution = new Solution_약수의합();

    assertEquals(28,solution.solution(12));
    assertEquals(6,solution.solution(5));
  }

}
