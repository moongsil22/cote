package lv2;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Stack;

import org.junit.Test;

public class 택배상자 {

    public int solution(int[] order) {
        int answer = 0;
        

        Stack<Integer> assist = new Stack<>();
        
        HashMap<Integer,Integer> container = new HashMap<>();

        
        // 택배 싣는 순서에 따른 각 박스의 위치 매핑
        for (int i = 0; i < order.length; i++) {
            int box = order[i];
            int position = i + 1; // 택배를 싣는 순서(1부터 시작)

            // boxToPositionMap에 (박스, 위치) 쌍 추가
            container.put(box, position);
        }

        int q=1;
        int idx=order.length+1;
        for(int s=1; s<idx; s++){
            if((!assist.isEmpty()) && assist.peek() == s){
                answer++;
                assist.pop();
                continue;
            }
            
            for(int i=q; i<idx; i++){
                if(container.size() == 0){
                    return answer;
                }
                
                if(container.get(i) != s){
            
                    assist.add(container.get(i));
                    container.remove(i);
                
                }else{
                    answer++;
                    container.remove(i);
                    q=i+1;
                    break;
                }
            
            }
   
        }

        return answer;
    }

    int getIndex(int x , int[] order){
        int answer=0;
        for(int i=0; i<order.length; i++){
            if(order[i]==x){
                return i+1;
            }
        }
        return answer;
    }

    @Test
    public void test() {
        택배상자 solution = new 택배상자();

         assertEquals(2, solution.solution(new int[] {4, 3, 1, 2, 5}));
         assertEquals(5, solution.solution(new int[] {5, 4, 3, 2, 1}));
    }



}
