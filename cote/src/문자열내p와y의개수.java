import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class 문자열내p와y의개수 {
    
    boolean solution(String s) {
        boolean answer = true;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        String lowS = s.toLowerCase();
        int pCnt = 0;
        int yCnt = 0;
        for(int i=0; i<lowS.length(); i++){
            if(lowS.charAt(i) == 'p'){
                pCnt++;
            }
            if(lowS.charAt(i) == 'y'){
                yCnt++;
            }
        }
        if(pCnt == yCnt){
            answer = true;
        }else{
            answer = false;
        }
        return answer;
    }
    
    boolean solution2(String s) {

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        String lowS = s.toLowerCase();
        return lowS.chars().filter(e -> 'p' == e).count() == lowS.chars().filter(e -> 'y' == e).count();
    }    
    
  @Test
  public void test1(){

    문자열내p와y의개수 solution = new 문자열내p와y의개수();


   assertEquals(true, solution.solution("pPoooyY"));
   assertEquals(false, solution.solution("Pyy"));

  }

  @Test
  public void test2(){

    문자열내p와y의개수 solution1 = new 문자열내p와y의개수();


   assertEquals(true, solution1.solution("pPoooyY"));
   assertEquals(false, solution1.solution("Pyy"));

  }  

}
