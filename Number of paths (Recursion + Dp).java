// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int m = Integer.parseInt(inputLine[0]);
		    int n = Integer.parseInt(inputLine[1]);
		    Solution ob = new Solution();
		    System.out.println(ob.numberOfPaths(m, n));
		}
	}
}



// } Driver Code Ends


class Solution{

    long numberOfPaths(int m, int n) {
        int [][] dp = new int [m][n];
        return getPaths (m, n, 0, 0, dp);
    }
    
    int getPaths (int m, int n, int currM, int currN, int [][] dp) {
        if (currM >= m || currN >= n)
            return 0;
        if (m-1 == currM && n-1 == currN) {
            return 1;
        }
        
        int right = 0;
        if (currM < m-1) {
           right = dp[currM+1][currN]; 
        }  
        if (right == 0)
            right = getPaths (m, n, currM+1, currN, dp);
        
        int left = 0;
        if (currN < n-1) {
           left = dp[currM][currN+1]; 
        }  
        if (left == 0)
            left = getPaths (m, n, currM, currN+1, dp);
        
        int count = left + right;
        dp[currM][currN] = count;
        
        return count;
    }
    
}