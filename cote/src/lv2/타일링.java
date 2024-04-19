package lv2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class 타일링 {

    public int solution(int n) {
        int answer = 0;
		int MOD = 1000000007;


		long[] factorial = new long[n+1];
		factorial[0] = 1;

		for(int i=1; i<=n; i++){
			factorial[i]= (factorial[i-1]*i)%MOD;
		}




		int secondCnt = n/2;

		for(int i=0; i<=secondCnt; i++){

			int fisrtCnt = n-i*2;
			
			long combination = factorial[fisrtCnt+i];

			combination = (combination * modInverse(MOD,(factorial[fisrtCnt]*factorial[i])%MOD))%MOD;

			answer = (answer + (int) combination)%MOD ;	

		}
        return answer%1000000007;
    }

	private long modInverse(long n, long b){

		long r1=n, r2=b;
		long t1 =0, t2=1;

		while(r2>0){
			long q = r1/r2;
			long r =  r1 - q*r2;

			r1 = r2;
			r2 = r;
			
			long t = t1-q*t2;
			t1 = t2;
			t2 = t;
		}

		if( r1 !=1){
			return 0;
		}
		if(t1<0){
			t1 = n + t1;
		}

		return t1;
	}

    public int solution2(int n) {
		int MOD = 1000000007;

		int[] dp = new int[n+1];

		dp[0] = 1;
		dp[1] = 1;

		for(int i=2; i<n+1; i++){
			dp[i] = (dp[i-2]+dp[i-1])%MOD;
		}

		return dp[n];
	}
	


    @Test
    public void test() {
        타일링 solution = new 타일링();
        assertEquals(5,solution.solution(4));
    }

	@Test
    public void test2() {
        타일링 solution = new 타일링();
        assertEquals(5,solution.solution2(4));
    }
}
