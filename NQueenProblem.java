import java.util.*;
import java.lang.*;
import java.io.*;
public class NQueenProblem
 {
    boolean ans = false;
	public static void main (String[] args)
	{
	    Scanner sc = new Scanner(System.in);
	    int cases = sc.nextInt();
	    while (cases --> 0) {
	        int n = sc.nextInt();
	        NQueenProblem g = new NQueenProblem();
	        g.solveNQueens(n);
	        System.out.println();
	    }
	}

    public void solveNQueens(int n) {
        boolean [] colBlock = new boolean [n];
        boolean [] leftDiagonal = new boolean[2*n];
        boolean [] rightDiagonal = new boolean[2*n];
        char [] [] board = new char [n][n];
        
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j ++) {
                board[i][j] = '.';
            }
        }
        
        NQueen (colBlock, board, 0, n, leftDiagonal, rightDiagonal);
        if (!ans)
            System.out.print(-1);
    }
    
   public void NQueen (boolean [] colBlock, char [] [] board, int row, int n, boolean [] leftDiagonal, boolean [] rightDiagonal) {
        //boolean ans = false;
        if (row == n) {
            for (int i = 0 ; i < n ; i++) {
            	for (int j = 0 ; j < n ; j++) {
            		System.out.print(board[i][j]);
            	}
            	System.out.println();
            }
            System.out.println();
            ans = true;
            return;
        }
        
        for (int i = 0 ; i < n ; i ++) {
            int diff = i - row + n - 1;
            int sum = i + row;
            if (!colBlock[i] && !rightDiagonal[diff] && !leftDiagonal[sum]) {
                colBlock[i] = true;
                rightDiagonal[diff] = true;
                leftDiagonal[sum] = true;
                board[row][i] = 'Q';
                NQueen (colBlock, board, row+1, n, leftDiagonal, rightDiagonal);
                board[row][i] = '.';
                leftDiagonal[sum] = false;
                rightDiagonal[diff] = false;
                colBlock[i] = false;
            }
        }
        
    }
 }