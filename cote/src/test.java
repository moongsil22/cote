import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class test {

    public static void main(String[] args) {
        
        int pair[][] = {{0,0},{0,1}};
        int pair2[][] = {{0,1},{0,0}};

        Set<String> pairSet = new HashSet<>();
        Arrays.sort(pair, new Comparator<int[]>() {
            @Override
            public int compare(final int[] entry1, final int[] entry2) {
                // x값으로 오름차순 정렬
                int xCompare = Integer.compare(entry1[0], entry2[0]);

                // x값이 같으면 y값으로 오름차순 정렬
                if (xCompare == 0) {
                    return Integer.compare(entry1[1], entry2[1]);
                } else {
                    return xCompare;
                }
            }
        });

        Arrays.sort(pair2, new Comparator<int[]>() {
            @Override
            public int compare(final int[] entry1, final int[] entry2) {
                // x값으로 오름차순 정렬
                int xCompare = Integer.compare(entry1[0], entry2[0]);

                // x값이 같으면 y값으로 오름차순 정렬
                if (xCompare == 0) {
                    return Integer.compare(entry1[1], entry2[1]);
                } else {
                    return xCompare;
                }
            }
        });

        String pairString1 = Arrays.deepToString(pair);
        String pairString2 = Arrays.deepToString(pair2);

        if(pairSet.add(pairString1)){
            System.out.println(pairString1);  
        }

        if(pairSet.add(pairString2)){
            System.out.println(pairString2);  
        }        
    }
    
}
