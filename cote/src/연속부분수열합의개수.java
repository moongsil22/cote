import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class 연속부분수열합의개수 {
    public int solution(int[] elements) {

        Set<Integer> sumSet = new HashSet<>();
        for(int i =1; i<elements.length; i++){
            for(int j=0; j<elements.length; j++){                
                int sum=0;
                for(int k=j; k<j+i; k++){
                sum+= elements[k%elements.length];
                }
                sumSet.add(sum);
            }
        }

        int totSum=0;
        for(int i=0; i<elements.length; i++){
            totSum+=elements[i];
        }
        sumSet.add(totSum);
        
        return sumSet.size();

    }


    @Test
    public void test(){

        연속부분수열합의개수 solution = new 연속부분수열합의개수();

        assertEquals(18,solution.solution(new int[]{7,9,1,1,4}));

    }

    public int solution2(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int[] dp = new int[elements.length];
        for(int len = 1;len <= elements.length; len++){
            for(int i = 0;i<elements.length;i++){
                dp[i] += elements[(len+i-1)%elements.length];
                set.add(dp[i]);
            }
        }
        return set.size();
    }

    @Test
    public void test2(){

        연속부분수열합의개수 solution = new 연속부분수열합의개수();

        assertEquals(18,solution.solution2(new int[]{7,9,1,1,4}));

    }

}


