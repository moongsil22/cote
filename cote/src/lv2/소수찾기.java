package lv2;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

public class 소수찾기 {

    static Set<Integer> set;
    static boolean[] visited;
    static String[] part;

    public int solution(String numbers) {
        set = new HashSet<>();
        visited = new boolean[numbers.length()];
        part = numbers.split("");

        permutation(0, "");
        return getAnswer();
    }

    private void permutation(int index, String sum) {
        if (!sum.isEmpty()) {
            set.add(Integer.parseInt(sum));
        }

        for (int i = 0; i < part.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation(index + 1, sum + part[i]);
                visited[i] = false;
            }
        }
    }

    private int getAnswer() {
        return set.stream()
                .filter(this::isPrimeNumber)
                .collect(Collectors.toList())
                .size();
    }

    private boolean isPrimeNumber(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void test() {
        소수찾기 solution = new 소수찾기();
        assertEquals(5,solution.solution("123"));
        //assertEquals(3,solution.solution("17"));
        //assertEquals(2,solution.solution("011"));



    }

}
