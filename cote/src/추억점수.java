import static org.junit.Assert.assertArrayEquals;

import java.util.HashMap;

import org.junit.Test;

public class 추억점수 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        HashMap<String,Integer> scoreMap = new HashMap();

        for(int i=0; i<name.length; i++){
            scoreMap.put(name[i],yearning[i]);
        }
        
        for(int i=0; i<photo.length; i++){
            for(int j=0; j<photo[i].length; j++){
                answer[i]+=scoreMap.getOrDefault(photo[i][j],0);
            }
        }

        return answer;
    }

@Test
public void test(){


    추억점수 solution = new 추억점수();

    assertArrayEquals(new int[]{19,15,6},
    solution.solution(
     new String[]{"may", "kein", "kain", "radi"}, 
     new int[]{5,10,1,3}, 
     new String[][]{{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"},{"kon", "kain", "may", "coni"}}));

     assertArrayEquals(new int[]{67, 0, 55},
     solution.solution(
      new String[]{"kali", "mari", "don"}, 
      new int[]{11, 1, 55}, 
      new String[][]{{"kali", "mari", "don"}, {"pony", "tom", "teddy"}, {"con", "mona", "don"}}));

      assertArrayEquals(new int[]{5, 15, 0},
      solution.solution(
       new String[]{"may", "kein", "kain", "radi"}, 
       new int[]{5, 10, 1, 3}, 
       new String[][]{{"may"},{"kein", "deny", "may"}, {"kon", "coni"}}));

    
}


}