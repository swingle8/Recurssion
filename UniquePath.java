class UniquePath {
    int count = 0;
    public static void main(String [] args) {
    	int [][] grid = {
    	{1, 0, 0, 0},
    	{0, 0, 0, 0},
    	{0, 0, -2, -1}
    	};
    	
    	UniquePath u = new UniquePath();
    	System.out.println(u.uniquePathsIII(grid));
    }
    public int uniquePathsIII(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int openCells = 0;
        int sourcei = 0;
        int sourcej = 0;
        int destinationi = 0;
        int destinationj = 0;
        boolean [][] blockedGrid = new boolean[rows][cols];
        
        for (int i = 0 ; i < rows ; i++) {
            for (int j = 0 ; j < cols ; j++) {
                if (grid[i][j] == 0)
                    openCells++;
                else if (grid[i][j] == 1) {
                    sourcei = i;
                    sourcej = j;
                    blockedGrid[i][j] = true;
                }
                else if (grid[i][j] == -2) {
                    destinationi = i;
                    destinationj = j;
                    openCells++;
                }
                else if (grid[i][j] == -1)
                	blockedGrid[i][j] = true;
            }
        }
        
        countPaths (grid, blockedGrid, openCells, 0, sourcei, sourcej, destinationi, destinationj);
        return count;
    }
    
    public void countPaths (int [][] grid, boolean [][] blockedGrid, int openCells, int currentClosed, int sourcei, int sourcej, int destinationi, int destinationj) {
        
        if (sourcei == destinationi && sourcej == destinationj && openCells == currentClosed) {
            count++;
            return;
        }
        else if (sourcei == destinationi && sourcej == destinationj)
        	return;
        
            sourcei++;
            if (sourcei >= 0 && sourcei < grid.length && !blockedGrid[sourcei][sourcej]) {
                blockedGrid[sourcei][sourcej] = true;
                currentClosed++;
                countPaths (grid, blockedGrid, openCells, currentClosed, sourcei, sourcej, destinationi, destinationj);
                
                blockedGrid[sourcei][sourcej] = false;
                currentClosed--;
                
            }
            
            sourcei--;    
            sourcei--;
            if (sourcei >= 0 && sourcei < grid.length && !blockedGrid[sourcei][sourcej]) {
                blockedGrid[sourcei][sourcej] = true;
                currentClosed++;
                countPaths (grid, blockedGrid, openCells, currentClosed, sourcei, sourcej, destinationi, destinationj);
                
                blockedGrid[sourcei][sourcej] = false;
                currentClosed--;
                
            }
        
            sourcei++;
            sourcej++;
            if (sourcej >= 0 && sourcej < grid[0].length && !blockedGrid[sourcei][sourcej]) {
                blockedGrid[sourcei][sourcej] = true;
                currentClosed++;
                countPaths (grid, blockedGrid, openCells, currentClosed, sourcei, sourcej, destinationi, destinationj);
                
                blockedGrid[sourcei][sourcej] = false;
                currentClosed--;
                
            }
        
            sourcej--;
            sourcej--;
            if (sourcej >= 0 && sourcej < grid[0].length && !blockedGrid[sourcei][sourcej]) {
                blockedGrid[sourcei][sourcej] = true;
                currentClosed++;
                countPaths (grid, blockedGrid, openCells, currentClosed, sourcei, sourcej, destinationi, destinationj);
                
                blockedGrid[sourcei][sourcej] = false;
                currentClosed--;
                
            }
        
    }
}