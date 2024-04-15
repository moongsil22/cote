package lv2;

import static org.junit.Assert.assertArrayEquals;

import java.util.Stack;

import org.junit.Test;

// 0은 벽 1은 벽아님. 1으로지나갈수 있다.

public class 뒤에있는큰수찾기 {

    public int[] solution(int[] numbers) {

        int[] answer = new int[numbers.length];
        
        Stack<Integer> stack = new Stack<>();
        
        answer[numbers.length-1] = -1;
        stack.add(numbers[numbers.length-1]);


        for(int i=numbers.length-2; i>=0; i--){
            while (!stack.isEmpty()) {
                
                if(stack.peek()>numbers[i]){
                    answer[i] = stack.peek(); 
                    break;
                }
                stack.pop();
            }
            if(answer[i] == 0){
                answer[i]=-1;
            }            
            stack.add(numbers[i]);
        }
        return answer;
    }



    @Test
    public void test(){
        뒤에있는큰수찾기 solution = new 뒤에있는큰수찾기();

        assertArrayEquals(new int[]{3,5,5,-1},solution.solution(new int[]{2, 3, 3, 5}) );
        assertArrayEquals(new int[]{-1, 5, 6, 6, -1, -1},solution.solution(new int[]{9, 1, 5, 3, 6, 2}) );

    }

}
