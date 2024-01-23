import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class 평균구하기 {
    public double solution1(int[] arr) {
        double answer = 0;

        for(int i=0; i<arr.length; i++){
            answer +=arr[i];
        }


        return answer/arr.length;
    }

  @Test
  public void test1(){

    평균구하기 solution = new 평균구하기();


   //int[] arr = {1,2,3,4};
   assertEquals(2.5, solution.solution1(new int[]{1,2,3,4}),0);

  }

    public double solution2(int[] arr) {

        return Arrays.stream(arr).average().orElse(0);
    }

  @Test
  public void test2(){

    평균구하기 solution = new 평균구하기();


   //int[] arr = {1,2,3,4};
   assertEquals(2.5, solution.solution2(new int[]{1,2,3,4}),0);

  }

}
