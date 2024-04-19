package lv2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class 다리를지나는트럭 {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

		String onBridge[] = new String [truck_weights.length];
		Arrays.fill(onBridge, "wait");
		
		int remainLength[] = new int[truck_weights.length];
		Arrays.fill(remainLength,bridge_length);

		Queue<Integer> que = new ArrayDeque<>();

		for(int i=0; i<truck_weights.length; i++){
			que.add(truck_weights[i]);
		}

		int remainWeight = weight;
		int i=0;
		
		int time=0;
		while(true){
			time++;
			if(allElementsEqualTo(onBridge,"out")){
				answer= time;
				break;
			}
			
			if(!que.isEmpty()){
				if(que.peek()<=remainWeight){
					remainWeight -= que.poll();
					onBridge[i] = "on";
					i++;
				}
			}

			for(int j =0; j<onBridge.length; j++){
				if("out".equals(onBridge[j])|| "wait".equals(onBridge[j])){
					continue;
				}
	
				if("on".equals(onBridge[j])){
					remainLength[j]-=1;
	
					if(remainLength[j]==0){
						onBridge[j] = "out";
						remainWeight += truck_weights[j];
					}
				}
			}

		}

		return answer;
    }

	public boolean allElementsEqualTo(String[] array, String target) {
		if (array == null || array.length == 0) {
			return false; // 배열이 비어있으면 false 반환
		}
	
		for (String str : array) {
			if (!target.equals(str)) {
				return false; // 특정 값과 다른 요소가 발견되면 false 반환
			}
		}
		return true; // 모든 요소가 특정 값과 동일하면 true 반환
	}	
	
    class Truck {
        int weight;
        int move;

        public Truck(int weight) {
            this.weight = weight;
            this.move = 1;
        }

        public void moving() {
            move++;
        }
    }

    public int solution2(int bridgeLength, int weight, int[] truckWeights) {
        Queue<Truck> waitQ = new LinkedList<>();
        Queue<Truck> moveQ = new LinkedList<>();

        for (int t : truckWeights) {
            waitQ.offer(new Truck(t));
        }

        int answer = 0;
        int curWeight = 0;

        while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
            answer++;

            if (moveQ.isEmpty()) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
                continue;
            }

            for (Truck t : moveQ) {
                t.moving();
            }

            if (moveQ.peek().move > bridgeLength) {
                Truck t = moveQ.poll();
                curWeight -= t.weight;
            }

            if (!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
            }
        }

        return answer;
    }	

    @Test
    public void test() {
        다리를지나는트럭 solution = new 다리를지나는트럭();
        assertEquals(8,solution.solution(2, 10, new int[]{7,4,5,6}));
		assertEquals(101,solution.solution(100, 100, new int[]{10}));
		assertEquals(110,solution.solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10}));
    }

    @Test
    public void test2() {
        다리를지나는트럭 solution = new 다리를지나는트럭();
        assertEquals(8,solution.solution2(2, 10, new int[]{7,4,5,6}));
		assertEquals(101,solution.solution2(100, 100, new int[]{10}));
		assertEquals(110,solution.solution2(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10}));
    }	
}
