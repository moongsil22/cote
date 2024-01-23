import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class 문자열정수바꾸기 {
    public int solution(String s) {
        int answer = 0;

        if (Character.isDigit(s.charAt(0))) {
            return Integer.parseInt(s);
        }

        for (int i = 1; i < s.length(); i++) {
            answer += Math.pow(10, s.length() - i - 1) * Character.getNumericValue(s.charAt(i));
        }
        return s.charAt(0) == '+' ? answer : (-1) * answer;
    }
    // +100
    // 4자리
    // 1*10^2 10^1 10^0

    public int getStrToInt(String str) {
        boolean Sign = true;
        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '-')
                Sign = false;
            else if (ch != '+')
                result = result * 10 + (ch - '0');
        }
        return Sign ? 1 : -1 * result;
    }

    @Test
    public void test1() {

        문자열정수바꾸기 solution = new 문자열정수바꾸기();

        // int[] arr = {1,2,3,4};
        assertEquals(1234, solution.solution("1234"));
        assertEquals(-1234, solution.solution("-1234"));
        assertEquals(-1234, solution.getStrToInt("-1234"));

    }
}
