import java.util.Arrays;

public class Solution_역순정렬 {

    public long solution(long n) {
        String[] list = String.valueOf(n).split("");
        Arrays.sort(list);

        StringBuilder sb = new StringBuilder();
        for (String aList : list) 
        sb.append(aList);

        return Long.parseLong(sb.reverse().toString());
    }
      
}
