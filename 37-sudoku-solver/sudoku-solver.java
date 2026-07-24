class Solution {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    public boolean solve(char[][] board, int row, int col)  {
        if(row == 9) return true;
        
        if(board[row][col] == '.') {
            for(int i = 1; i <= 9;i++) {
                if(isValid(row, col, i, board)) {
                    board[row][col] = (char) (48 + i);
                    if(col == 8) {
                        if(solve(board, row + 1, 0)) return true;
                    }else {
                        if(solve(board, row, col + 1)) return true;
                    }
                    board[row][col] = '.';
                }
            }

            return false;
        }else {
            if(col == 8) {
                if(solve(board, row + 1, 0)) return true;
            }else {
                if(solve(board, row, col + 1)) return true;
            }

            return false;
        }
    }

    public boolean isValid(int row,int col,int i,char[][] board) {
        for(int j = 0;j < 9;j++) {
            if(board[row][j] == (char) (48 + i)) return false;
        }

        for(int j = 0;j < 9;j++) {
            if(board[j][col] == (char) (48 + i)) return false;
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for(int j = startRow; j <= startRow + 2;j++) {
            for(int k = startCol; k <= startCol + 2;k++) {
                if(board[j][k] == (char) (48 + i)) return false;
            }
        }

        return true;
    }
}