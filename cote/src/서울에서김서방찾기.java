import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class 서울에서김서방찾기 {
    public String solution(String[] seoul) {
        String answer = "";

        for(int i=0; i<seoul.length; i++){
             if("Kim".equals(seoul[i])){
                answer = "김서방은 " +i+"에 있다"; 
             }
        }


        return answer;
    }

  @Test
  public void test1(){

    서울에서김서방찾기 solution = new 서울에서김서방찾기();


   //int[] arr = {1,2,3,4};
   assertEquals("김서방은 1에 있다", solution.solution(new String[]{"Jane","Kim"}));

  }

}
