import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class 방문길이 {
    
    
    public int solution(String dirs) {
        int answer = 0;

        int startPoint[][] = new int[dirs.length()][2];
        int endPoint[][] = new int[dirs.length()][2];
        
        int x = 0; 
        int y= 0;
 
        for(int i =0; i<dirs.length(); i++){
            
            if(x==5){
                if(dirs.charAt(i)=='R'){
                    continue;
                }
            }
            
            if(x==-5){
                if(dirs.charAt(i)=='L'){
                    continue;
                }
            }            
            
            if(y==5){
                if(dirs.charAt(i)=='U'){
                    continue;
                }
            }
            
            if(y==-5){
                if(dirs.charAt(i)=='D'){
                    continue;
                }
            }            
            startPoint[i][0]=x;
            startPoint[i][1]=y;


            
            if(dirs.charAt(i) == 'R'){
                x+=1;
            }
            if(dirs.charAt(i) == 'L'){
                x-=1;
            }
            if(dirs.charAt(i) == 'U'){
                y+=1;
            }
            if(dirs.charAt(i) == 'D'){
                y-=1;
            }

            endPoint[i][0]=x;
            endPoint[i][1]=y;
        }

        // paired 배열 생성
        List<int[][]> pairedList = new ArrayList<>();

        for (int i = 0; i < dirs.length(); i++) {
            int[][] pair = new int[2][2];

            if (!Arrays.equals(startPoint[i], endPoint[i])) {
                pair[0] = startPoint[i];
                pair[1] = endPoint[i];
                pairedList.add(pair);
            }
        }

        // 중복된 쌍 제거
        Set<String> pairSet = new HashSet<>();
        List<int[][]> uniquePairs = new ArrayList<>();

        for (int[][] pair : pairedList) {
            // 정렬 없이 그대로 문자열로 변환하여 Set에 추가
            String pairString = Arrays.deepToString(pair);
            
            if (pairSet.add(pairString)) {
                // Set에 추가된 경우만 uniquePairs 리스트에 추가
                uniquePairs.add(pair);
            }
        }

        return uniquePairs.size();
    }
    
    // 배열 출력 메소드
    private static void printPairedArray(int[][][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("[" + i + "]th = {" + array[i][0][0] + "," + array[i][0][1] + "}, {" +
                                                  array[i][1][0] + "," + array[i][1][1] + "}");
        }
    }    
    
  @Test
  public void test1(){

    방문길이 solution = new 방문길이();


   //int[] arr = {1,2,3,4};
  // assertEquals(7, solution.solution("ULURRDLLU"));
   assertEquals(7, solution.solution("LULLLLLLU"));

  }

}
