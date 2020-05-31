class Sudoku {

    boolean ans = false;
    public static void main(String []args) {
    	char[][] board = new char[][] { 
    		{'.', '8', '7', '6', '5', '4', '3', '2', '1'}, 
    		{'2', '.', '.', '.', '.', '.', '.', '.', '.'}, 
    		{'3', '.', '.', '.', '.', '.', '.', '.', '.'}, 
    		{'4', '.', '.', '.', '.', '.', '.', '.', '.'}, 
            {'5', '.', '.', '.', '.', '.', '.', '.', '.'}, 
            {'6', '.', '.', '.', '.', '.', '.', '.', '.'}, 
            {'7', '.', '.', '.', '.', '.', '.', '.', '.'}, 
            {'8', '.', '.', '.', '.', '.', '.', '.', '.'}, 
            {'9', '.', '.', '.', '.', '.', '.', '.', '.'}
        }; 
        
        Sudoku s = new Sudoku();
        System.out.println(s.isValidSudoku(board));
    }
    public boolean isValidSudoku(char[][] board) {
        boolean [][] rows = new boolean [9][10];
        boolean [][] cols = new boolean [9][10];
        boolean [][][] block = new boolean [3][3][10];
        for (int i = 0; i < 9 ; i ++) {
            for (int j = 0; j < 9 ; j++) {
                if (board[i][j] != '.') {
                   int l = Character.getNumericValue(board[i][j]);
                    rows[i][l] = true;
                    cols[j][l] = true;
                    block[i/3][j/3][l] = true;

                }
            }
        }
		

		
        isValid (board, rows, cols, block, 0);
        return ans;
    }
    
    public void isValid (char [][] board, boolean [][] rows, boolean [][] cols, boolean [][][] block, int curr_index) {
           if (curr_index == 81) {
               ans = true;
               return;
           }
        
            int i = curr_index/9;
            int j = curr_index%9;
            if (board[i][j] != '.' && !ans) {
                isValid(board, rows, cols, block, curr_index+1);
            }
                
             
        
            for (int k = 1 ; k < 10 ; k ++) {
                if (board[i][j] == '.' && !rows[i][k] && !cols[j][k] && !block[i/3][j/3][k] && !ans) {
                    
                    board[i][j] = Character.forDigit(k,10);
                    rows[i][k] = true;
                    cols[j][k] = true;
                    block[i/3][j/3][k] = true;                    
                    isValid(board, rows, cols, block, curr_index+1);
                    board[i][j] = '.';
                    rows[i][k] = false;
                    cols[j][k] = false;
                    block[i/3][j/3][k] = false;
                }
             
            }
    }
}