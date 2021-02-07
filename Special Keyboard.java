// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.optimalKeys(N));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    //static int ans = 0;
    static int optimalKeys(int N){
       if (N <= 6)
        return N;
       int [] dp = new int[N+1];
        getMaxAs(N, dp);
       
       return dp[N];
    }
    
    
    static int getMaxAs (int N, int [] dp) {
        
        if (N < 0)
            return 0;
        if (N <= 3)
            return N;
        if (dp[N] > 0)
            return dp[N];
        int ans = N;
        for (int i = N-2 ; i >= 0 ; i--) {
            int maxTillI = getMaxAs(i-1, dp);
            int currmax = maxTillI + (N-i-1)*maxTillI;
            ans = Math.max(ans, currmax);
        }
        
        dp[N] = ans;
        return ans;
    }
}


