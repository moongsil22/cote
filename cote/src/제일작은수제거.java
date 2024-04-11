import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class 제일작은수제거 {
    public int[] solution(int[] arr) {
        int min = arr[0];

        if(arr.length ==1){
            return new int[]{-1};
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        List<Integer> list = new ArrayList<>(); 
        
        for(int i=0; i<arr.length; i++){
            if( arr[i] != min){
                list.add(arr[i]);
            }
        }

        int[] array = list.stream().mapToInt(Integer::intValue).toArray();
        return array;
    }  

    public int[] solution2(int[] arr){

        if(arr.length <=1) return new int[]{-1};

        int min = Arrays.stream(arr).min().getAsInt();
        return Arrays.stream(arr).filter(i -> i != min).toArray();
    }

@Test
public void test(){


    제일작은수제거 solution = new 제일작은수제거();

    assertArrayEquals(new int[]{4,3,2}, solution.solution(new int[]{4,3,2,1}));
    assertArrayEquals(new int[]{-1}, solution.solution(new int[]{10}));

}

@Test
public void test2(){


    제일작은수제거 solution = new 제일작은수제거();

    assertArrayEquals(new int[]{4,3,2}, solution.solution2(new int[]{4,3,2,1}));
    assertArrayEquals(new int[]{-1}, solution.solution2(new int[]{10}));

}


}