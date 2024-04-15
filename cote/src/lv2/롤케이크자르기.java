package lv2;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;



public class 롤케이크자르기 {

    public int solution(int[] topping) {
        int answer=0;

        HashMap<Integer,Integer> hm1 = new HashMap<>();
        HashMap<Integer,Integer> hm2 = new HashMap<>();

        for(int i=0; i<topping.length; i++){
            hm1.put(topping[i], hm1.getOrDefault(topping[i], 0)+1);  
        }    

        if(hm1.size() ==1){
            return topping.length -1;
        }
        int half = hm1.size()%2 ==1 ? (hm1.size()/2)+1 : (hm1.size()/2);

        for(int i=0; i<topping.length; i++){
            
            
            if(hm1.size()<half){
                break;
            }
            
            if(hm1.containsKey(topping[i])){
                hm2.put(topping[i], hm1.getOrDefault(topping[i], 0)+1);
                if(hm1.get(topping[i])>1){ 
                    hm1.put(topping[i], hm1.getOrDefault(topping[i], 0)-1);
                }else{
                    hm1.remove(topping[i]);
                }  
            }

            if(hm1.size() ==hm2.size()){
                answer++;
            }

        }
        return answer;
    }

    public int solution2(int[] topping) {
        int answer = 0;
        int[] left = new int[10001], right = new int[10001];
        int ls = 0, rs = 0;
        for(var i : topping) right[i]++;
        for(var i : right) rs += i > 0 ? 1 : 0;
        for(var i : topping) {
            right[i]--;
            if (right[i] == 0) rs--;
            if (left[i] == 0) ls++;
            left[i]++;
            if (rs == ls) answer++;
        }
        return answer;
    }

    @Test
    public void test(){
        롤케이크자르기 solution = new 롤케이크자르기();

        assertEquals(2,solution.solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2}) );
        assertEquals(0,solution.solution(new int[]{1, 2, 3, 1, 4}) );

    }

    @Test
    public void test2(){
        롤케이크자르기 solution = new 롤케이크자르기();

        assertEquals(2,solution.solution2(new int[]{1, 2, 1, 3, 1, 4, 1, 2}) );
        assertEquals(0,solution.solution2(new int[]{1, 2, 3, 1, 4}) );

    }

}
