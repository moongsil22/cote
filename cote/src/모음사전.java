import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class 모음사전 {
    private static int answer;
    private static String[] alphabet = {"A","E","I","O","U"};
    private static String[] result;
    private static boolean go = true;

    @Before
    public void setUp() {
        this.answer = 0;
        this.result = null;
        this.go = true;
    }
    public int solution(String word) {
        answer = 0;
        String[] words = word.split("");
        result = new String[word.length()];
        dfs(0,words, result);

        return answer;
    }

    public static void dfs(int depth, String[] words, String[] result){
        if(depth >= 5){
            return;
        }

        for(int i=0; i<5; i++){
            if(depth < words.length){
                result[depth] = alphabet[i];
            }
            answer++;
            if(depth >=words.length-1 && Arrays.equals(words,result)){
                go = false;
                break;
            }
            dfs(depth+1, words,result);
            if(!go){
                return;
            }
        }
    }

    @Test
    public void testAAAAE() {
        모음사전 solution = new 모음사전();
        assertEquals(6, solution.solution("AAAAE"));
    }

    @Test
    public void testAAAE() {
        모음사전 solution = new 모음사전();
        assertEquals(10, solution.solution("AAAE"));
    }

    @Test
    public void testI() {
        모음사전 solution = new 모음사전();
        assertEquals(1563, solution.solution("I"));
    }

    @Test
    public void testEIO() {
        모음사전 solution = new 모음사전();
        assertEquals(1189, solution.solution("EIO"));
    }
}
