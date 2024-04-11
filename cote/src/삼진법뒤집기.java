import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class 삼진법뒤집기 {
    public int solution(int n) {
        int answer = 0;
        List<Integer> list = new ArrayList();

        while(n!=0){
            list.add(n%3);
            n/=3;
        }

        for(int i =0; i<list.size(); i++){
            answer+=list.get(i)*Math.pow(3, list.size()-1-i);
        }
        
        return answer;
    }

    public int solution2(int n) {
        String a="";
        while(n!=0){
            a= (n%3) +a;
            n/=3;
        }

        a= new StringBuilder(a).reverse().toString();
        
        return Integer.parseInt(a,3);
    }    

@Test
public void test(){


    삼진법뒤집기 solution = new 삼진법뒤집기();

    assertEquals(7, solution.solution(45));
    assertEquals(229, solution.solution(125));

    assertEquals(7, solution.solution2(45));
    assertEquals(229, solution.solution2(125));

}


}