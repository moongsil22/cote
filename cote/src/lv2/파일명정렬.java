package lv2;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class 파일명정렬 {

    public String[] solution(String[] files) {

        List<String> list = new ArrayList<>(Arrays.asList(files));

        list.sort(new Comparator<String>() {
           @Override
           public int compare(String o1, String o2){
                    
                String str1FirstPart = getFirstPart(o1);
                String str2FirstPart = getFirstPart(o2);            
                int alphaComparison = str1FirstPart.compareToIgnoreCase(str2FirstPart);
                if (alphaComparison != 0) {
                    return alphaComparison; // 알파벳 부분이 다르면 바로 반환
                    
                }
            
                Integer num1 = extractNumber(o1); 
                Integer num2 = extractNumber(o2);
                
                if(num1 != null && num2 != null){
                    return num1.compareTo(num2);
                }

                return alphaComparison;
           } 
        });

        
        return list.toArray(new String[0]);
    }

    //숫자나오기 이전까지 자름.
    private String getFirstPart(String str) {
        Pattern pattern = Pattern.compile("[^0-9]+");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(); // 첫 번째 알파벳 부분 반환
        }
        return ""; // 알파벳 부분이 없으면 빈 문자열 반환
    }

    private Integer extractNumber(String str){
        StringBuilder numStr= new StringBuilder();
        boolean foundDigit = false;

        for(char ch: str.toCharArray()){
            if(Character.isDigit(ch)){
                numStr.append(ch);
                foundDigit = true;
            }else{
                if(foundDigit){
                    break;
                }
            }
        }

        if(numStr.length() > 0){
            return Integer.parseInt(numStr.toString());
        }else{
            return null;
        }
    }

    // ([a-z\\s.-]+): 이 부분은 첫 번째 그룹을 나타내며, 소문자 알파벳(a-z), 공백(\\s), 마침표(.), 하이픈(-)으로 이루어진 하나 이상의 문자열을 찾습니다.
    // ([0-9]{1,5}): 이 부분은 두 번째 그룹을 나타내며, 숫자(0-9)로 이루어진 1자리에서 5자리까지의 숫자를 찾습니다.

    public String[] solution2(String[] files) {
        Pattern p = Pattern.compile("([a-z\\s.-]+)([0-9]{1,5})");

        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                Matcher m1 = p.matcher(s1.toLowerCase());
                Matcher m2 = p.matcher(s2.toLowerCase());
                m1.find();
                m2.find();

                if(!m1.group(1).equals(m2.group(1))) {
                    return m1.group(1).compareTo(m2.group(1));
                } else {
                    return Integer.parseInt(m1.group(2)) - Integer.parseInt(m2.group(2));
                }
            }
        });

        return files;
    }

    @Test
    public void test() {
        파일명정렬 solution = new 파일명정렬();

         assertArrayEquals(new String[]{"img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"}, solution.solution(new String[] { "img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG" }));
         assertArrayEquals(new String[]{ "A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"}, solution.solution(new String[] { "F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat" }));
        assertArrayEquals(new String[]{ "MUZI01ba.cde","muzi01ab.abc"}, solution.solution(new String[] { "MUZI01ba.cde","muzi01ab.abc" }));
    }

    @Test
    public void test2() {
        파일명정렬 solution = new 파일명정렬();

         assertArrayEquals(new String[]{"img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"}, solution.solution(new String[] { "img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG" }));
         assertArrayEquals(new String[]{ "A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"}, solution.solution(new String[] { "F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat" }));
        assertArrayEquals(new String[]{ "MUZI01ba.cde","muzi01ab.abc"}, solution.solution(new String[] { "MUZI01ba.cde","muzi01ab.abc" }));
    }

}
