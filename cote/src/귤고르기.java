import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class 귤고르기 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<tangerine.length; i++){
            
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0)+1);
        }
        
        // Map.Entry 리스트 생성
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());

        // Comparator를 이용하여 값에 따라 내림차순 정렬
        entryList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        // 정렬된 결과 출력
        for (Map.Entry<Integer, Integer> entry : entryList) {
            k = k - entry.getValue();
            answer++;
            if(k<=0){
                break;
            }
        }
        return answer;
    }

    @Test
    public void test(){
        귤고르기 solution = new 귤고르기();

        assertEquals(3,solution.solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}) );
        assertEquals(2,solution.solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}) );
        assertEquals(1,solution.solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}) );

    }

}
