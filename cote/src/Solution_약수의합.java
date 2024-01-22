public class Solution_약수의합 {
    public int solution(int n) {
        int answer = 0;

        for(int i=1; i<=n; i++){
            if(n%i ==0){
                answer+=i;
            }
        }
        return answer;
    }    
    
}

// Key Point : num/2 

// public int sumDivisor(int num) {
//     int answer = 0;
// for(int i =1 ; i<=num/2;i++){
//   if(num%i==0){
//     answer+=i;}}


//     return answer+num;
// }