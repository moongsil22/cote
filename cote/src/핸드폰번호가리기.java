import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class 핸드폰번호가리기 {
    public String solution(String phone_number) {

        String[] strArr = new String[phone_number.length()];

        for (int i = strArr.length - 1; i >= 0; i--) {
            if (i > strArr.length - 1 - 4) {
                strArr[i] = String.valueOf(phone_number.charAt(i));
            } else {
                strArr[i] = "*";
            }
        }

        return String.join("", strArr);
    }

    public String solution2(String phone_number) {
        char[] ch = phone_number.toCharArray();
        for (int i = 0; i < ch.length - 4; i++) {
            ch[i] = '*';
        }
        return String.valueOf(ch);
    }

    public String solution3(String phone_number) {
        return phone_number.replaceAll(".(?=.{4})", "*");
    }

    @Test
    public void test1() {

        핸드폰번호가리기 solution = new 핸드폰번호가리기();

        // int[] arr = {1,2,3,4};
        assertEquals("*******4444", solution.solution("01033334444"));
        assertEquals("*****8888", solution.solution("027778888"));

    }
}
