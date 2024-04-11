import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class 자연수뒤집어배열만들기 {
    public int[] solution(long n) {
        
        String sn = String.valueOf(n);
        List<Integer> list = new ArrayList();
        
        for(int i = sn.length()-1; i>=0 ; i--){
            list.add(Integer.valueOf(sn.substring(i, i+1)));
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }


    public int[] solution2(long n) {
                
        return new StringBuilder().append(n).reverse().chars().map(Character::getNumericValue).toArray();
    }    

@Test
public void test(){


    자연수뒤집어배열만들기 solution = new 자연수뒤집어배열만들기();

    assertArrayEquals(new int[]{5,4,3,2,1}, solution.solution(12345));

}

@Test
public void test2(){


    자연수뒤집어배열만들기 solution = new 자연수뒤집어배열만들기();

    assertArrayEquals(new int[]{5,4,3,2,1}, solution.solution2(12345));

}


}