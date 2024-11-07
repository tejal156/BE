import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ass3{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0) {
            // Read capacity
            int capacity = Integer.parseInt(br.readLine());

            // Read values
            String[] valInput = br.readLine().split(" ");
            int[] val = new int[valInput.length];
            for (int i = 0; i < valInput.length; i++) {
                val[i] = Integer.parseInt(valInput[i]);
            }

            // Read weights
            String[] wtInput = br.readLine().split(" ");
            int[] wt = new int[wtInput.length];
            for (int i = 0; i < wtInput.length; i++) {
                wt[i] = Integer.parseInt(wtInput[i]);
            }

            // Call the knapSack function and print the result
            System.out.println(Solution.knapSack(capacity, val, wt));
            System.out.println("~");
        }
    }
}


class Solution {
    // Function to return max value that can be put in knapsack of capacity.
    static int knapSack(int capacity, int val[], int wt[]) {
        // code here
        int dp[][] = new int[val.length][capacity+1]  ;
        for(int i = 0 ; i < val.length ; i++){
            for(int j = 0 ; j <capacity+1 ; j++ )dp[i][j] = -1 ; 
        }
        
        return helperFun( dp, 0 , capacity , val,wt) ;
    }
    
    static int helperFun(int dp[][] , int ci , int cc ,int val[], int wt[]) {
        if(ci >= val.length || cc < 0 ){
            return 0 ; 
        }
    
        
        if(dp[ci][cc] != -1)return dp[ci][cc] ; 
        int p1 =  helperFun( dp, ci+1 , cc , val,wt) ;
        int p2 = 0 ;
        if( cc >= wt[ci]){
            p2 = helperFun( dp, ci+1 , cc-wt[ci] , val,wt)+val[ci] ;
        }
        
        return dp[ci][cc] = Math.max(p1 ,p2 ) ;
        
    }
}

