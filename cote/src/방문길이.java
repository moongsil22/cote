import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
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
            // Comparator를 이용한 정렬
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

    public int solution1(String dirs) {
        int answer = 0;

       // int startPoint[][] = new int[dirs.length()][2];
       // int endPoint[][] = new int[dirs.length()][2];
        
       ArrayList<Point> startPoint = new ArrayList<>();
       ArrayList<Point> endPoint = new ArrayList<>();
       ArrayList<PointPair> pointPairs = new ArrayList<>();
        
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
            Point currentStartPoint = new Point(x, y);  // 현재 x, y로 Point 생성
            startPoint.add(currentStartPoint);

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

            Point currentEndPoint = new Point(x, y);  // 현재 x, y로 Point 생성
            endPoint.add(currentEndPoint);

            pointPairs.add(new PointPair(currentStartPoint, currentEndPoint));
        }


        // HashMap을 이용하여 중복된 PointPair를 제거하고 개수를 셈
        HashMap<PointPair, Integer> pointPairCount = new HashMap<>();
        for (PointPair pair : pointPairs) {
           // PointPair sortedPair = new PointPair(pair.getStartPoint(), pair.getEndPoint());
           pair.sortPoints();

            int hashCode = pair.hashCode();
            boolean equals = pair.equals(pair);
            // 디버깅 출력
            System.out.println("HashCode: " + hashCode + ", Equals: " + equals);

            pointPairCount.put(pair, pointPairCount.getOrDefault(pair, 0) + 1);
        }
        System.out.println("pointPairCount: " + pointPairCount.toString());

        // // 중복된 쌍 제거
        // Set<String> pairSet = new HashSet<>();
        // List<PointPair> uniquePairs = new ArrayList<>();

        // for (PointPair pointPair : pointPairs) {
        //     // Comparator를 이용한 정렬
        //     pointPair.sortPoints();
            
        //     String pairString = pointPair.toString();
            
        //     if (pairSet.add(pairString)) {
        //         // Set에 추가된 경우만 uniquePairs 리스트에 추가
        //         uniquePairs.add(pointPair);
        //     }
        // }

        //return uniquePairs.size();
        return pointPairCount.size();
    }
    




  @Test
  public void test1(){

    방문길이 solution = new 방문길이();


   //int[] arr = {1,2,3,4};
  // assertEquals(7, solution.solution("ULURRDLLU"));
   assertEquals(7, solution.solution("LULLLLLLU"));

  }

  @Test
  public void test2(){

    방문길이 solution = new 방문길이();


   //int[] arr = {1,2,3,4};
   assertEquals(7, solution.solution1("ULURRDLLU"));
   //assertEquals(7, solution.solution1("LULLLLLLU"));

  }

  class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "{" + x + ", " + y + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
               y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }    
}

class PointPair {
    private Point startPoint;
    private Point endPoint;

    public PointPair(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        //sortPoints(); 
    }

    public Point getStartPoint() {
        // 새로운 Point 객체 반환
        //return new Point(startPoint.getX(), startPoint.getY());
        return startPoint;
    }

    public Point getEndPoint() {
        // 새로운 Point 객체 반환
        //return new Point(endPoint.getX(), endPoint.getY());
        return endPoint;
    }

    public void sortPoints() {
        if (startPoint.getX() > endPoint.getX() || 
           (startPoint.getX() == endPoint.getX() && startPoint.getY() > endPoint.getY())) {
            // Swap points if they are not in the desired order
            Point temp = startPoint;
            startPoint = endPoint;
            endPoint = temp;
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointPair pointPair = (PointPair) o;
        return Objects.equals(startPoint, pointPair.startPoint) &&
               Objects.equals(endPoint, pointPair.endPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startPoint, endPoint);
    }

    @Override
    public String toString() {
        return "Start: " + startPoint + ", End: " + endPoint;
    }
}

}

