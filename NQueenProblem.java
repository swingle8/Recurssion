import java.util.*;
import java.lang.*;
import java.io.*;
class NQueenProblem
 {
	public static void main (String[] args)
	{
	    Scanner sc = new Scanner(System.in);
	    int cases = sc.nextInt();
	    while (cases --> 0) {
	        int n = sc.nextInt();
	        NQueenProblem g = new NQueenProblem();
	        g.solveNQueens(n);
	    }
	}

    public void solveNQueens(int n) {
        boolean [] colBlock = new boolean [n];
        char [] [] board = new char [n][n];
        
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j ++) {
                board[i][j] = '.';
            }
        }
        
        boolean [] [] diag = new boolean [n][n];
        NQueen (colBlock, board, diag, 0, n);
    }
    
    public void NQueen (boolean [] colBlock, char [] [] board, boolean [] [] diag, int row, int n) {
        if (row == n) {
            //System.out.println("here");
            for (int i = 0 ; i < n ; i++) {
                for (int j = 0 ; j < n ; j ++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();    
            }
            System.out.println();
            return;
        }
        
        for (int i = 0 ; i < n ; i ++) {
            if (!colBlock[i] && !diag[row][i]) {
                colBlock[i] = true;
                diag = blockDiagnol(row, i, diag, n);
                board[row][i] = 'Q';
                NQueen (colBlock, board, diag, row+1, n);
                board[row][i] = '.';
                diag = unblockDiagnol(row, i, diag, n);
                colBlock[i] = false;
            }
        }
    }
    
   public boolean [][] blockDiagnol (int row, int col, boolean [][] diag, int n) {
        int sum = row + col;
        int diff = col - row;
        
        for (int i = row+1 ; i < n ; i ++) {
            
            int j = diff + i;
            if (j < n && j >= 0)
                diag[i][j] = true;
            j = sum - i;
            if (j < n && j >= 0)
                diag[i][j] = true;
        }
        
        return diag;
    }
    
    public boolean [][] unblockDiagnol (int row, int col, boolean [][] diag, int n) {
        int sum = row + col;
        int diff = col - row;
        
        for (int i = row+1 ; i < n ; i ++) {
            int j = diff + i;
            if (j < n && j >= 0)
                diag[i][j] = false;
            j = sum - i;
            if (j < n && j >= 0)
                diag[i][j] = false;
        }
        
        return diag;
    }
 }