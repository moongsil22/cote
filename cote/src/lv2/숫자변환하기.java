package lv2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import org.junit.Test;



public class 숫자변환하기 {

    public int solution(int x, int y, int n) {
        int count=0;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(x);
        visited.add(x);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i< size; i++){
                int cur= queue.poll();
                if (cur == y){
                    return count;
                }
                if(cur+n<=y && !visited.contains(cur+n)){
                    queue.add(cur+n);
                    visited.add(cur+n);
                }
                if(cur*2<=y && !visited.contains(cur*2)){
                    queue.add(cur*2);
                    visited.add(cur*2);
                }
                if(cur*3<=y && !visited.contains(cur*3)){
                    queue.add(cur*3);
                    visited.add(cur*3);
                }                
            }
            count++;
        }
        return -1;
    }

    private static final int MAX_VALUE = 1_000_000;
    private final int[] visitCount = new int[MAX_VALUE + 1];
    private final Queue<Integer> queue = new ArrayDeque<>();

    public int solution2(int x, int y, int n) {
        return bfs(x, y, n);
    }

    private int bfs(int source, int target, int n) {
        queue.add(source);
        while (!queue.isEmpty()) {
            int value = queue.poll();
            if (value == target) {
                return visitCount[value];
            }
            addQueue(target, value, value + n);
            addQueue(target, value, value * 2);
            addQueue(target, value, value * 3);
        }
        return -1;
    }

    private void addQueue(int target, int value, int nextValue) {
        if (nextValue <= target && visitCount[nextValue] == 0) {
            queue.add(nextValue);
            visitCount[nextValue] = visitCount[value] + 1;
        }
    }


    @Test
    public void test(){
        숫자변환하기 solution = new 숫자변환하기();

        assertEquals(2,solution.solution(10,40,5) );
        // assertEquals(1,solution.solution(10,40,30) );
        // assertEquals(-1,solution.solution(2,5,4) );
    }

    @Test
    public void test2(){
        숫자변환하기 solution = new 숫자변환하기();

        assertEquals(2,solution.solution2(10,40,5) );
        // assertEquals(1,solution.solution(10,40,30) );
        // assertEquals(-1,solution.solution(2,5,4) );
    }


}
