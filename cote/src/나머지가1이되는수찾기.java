import static org.junit.Assert.assertEquals;

import java.util.stream.IntStream;

import org.junit.Test;

public class 나머지가1이되는수찾기 {
    public int solution(int n) {
        int answer = 0;

        for(int i=1; i<n; i++){
            if(n%i==1){
                answer=i;
                break;
            }
        }
        return answer;
    }

//Stream 예제

    public int solution2(int n) {
        return IntStream.range(2, n).filter(i -> n % i == 1).findFirst().orElse(0);
    }

    @Test
    public void test1() {

        나머지가1이되는수찾기 solution = new 나머지가1이되는수찾기();

        // int[] arr = {1,2,3,4};
        assertEquals(3, solution.solution(10));
        assertEquals(11, solution.solution(12));

    }    

}
