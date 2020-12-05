/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static int ans = 0;
	public static void main (String[] args) throws java.lang.Exception
	{
	    int [][] mat = {{9, 29, 4},{6, 16, 8}, {2, 10, 1}};
	    getLongestPath(mat);
	}
	
	public static void getLongestPath (int [][] mat) {
	    int rows = mat.length;
	    int cols = mat[0].length;
	    //int [] visitedLength = new int [rows][cols];
	    ans = 0;
	    for (int i = 0 ; i < rows ; i++) {
	        for (int j = 0 ; j < cols ; j ++) {
	            getMaxPathFromHere(i, j, mat, 0);
	        }
	    }
	    System.out.println(ans);
	}
	
	public static void getMaxPathFromHere (int i, int j, int [][] mat, int len) {
	       int blockedNeigh = 0;
	        
	        if (j > 0 && mat[i][j-1] > mat[i][j]) {
	            j = j-1;
	            len++;
	            getMaxPathFromHere (i, j, mat, len);
	            len--;
	            j = j + 1;
	        }
	        else
	            blockedNeigh = blockedNeigh + 1;
	    
	        if (j < mat[0].length-1 && mat[i][j+1] > mat[i][j]) {
	            j = j+1;
	            len++;
	            getMaxPathFromHere (i, j, mat, len);
	            len--;
	            j = j - 1;
	        }
	         else
	            blockedNeigh = blockedNeigh + 1;
	        
	        if (i < mat.length-1 && mat[i+1][j] > mat[i][j]) {
	            i = i+1;
	            len++;
	            getMaxPathFromHere (i, j, mat, len);
	            len--;
	            i = i - 1;
	        } 
	        else
	            blockedNeigh = blockedNeigh + 1;
	        
	        
	        if (i > 0 && mat[i-1][j] > mat[i][j]) {
	            i = i-1;
	            len++;
	            getMaxPathFromHere (i, j, mat, len);
	            len--;
	            i = i + 1;
	        }
	         else
	            blockedNeigh = blockedNeigh + 1;
	        
	        //System.out.println(blockedNeigh);
	        if (blockedNeigh == 4) {
	            if (ans < len)
	                ans = len;
	           return;
	        }
	            
	    }
	        
	   
	        
	}
