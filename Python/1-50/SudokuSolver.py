class Solution(object):
    def solveSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        if len(board) == 0 or len(board[0]) == 0:
            return
        self.dfs(board)
    def dfs(self, board):
        def validRow(row, val):
            for i in range(9):
                if board[row][i] != '.' and board[row][i] == val:
                    return False
            return True
        def validCol(col, val):
            for i in range(9):
                if board[i][col] != '.' and board[i][col] == val:
                    return False
            return True
        def validCell(row, col, val):
            for i in range(row, row + 3):
                for j in range(col, col + 3):
                    if board[i][j] != '.' and board[i][j] == val:
                        return False
            return True
        def valid(row, col, val):
            r, c = row // 3 * 3, col // 3 * 3
            return validRow(row, val) and validCol(col, val) and validCell(r, c, val)
        s = [ str(i) for i in range(1, 10) ]
        for i in range(9):
            for j in range(9):
                if board[i][j] == '.':
                    for v in s:
                        if valid(i, j, v):
                            board[i][j] = v
                            if self.dfs(board):
                                return True
                            board[i][j] = '.'
                    return False
        return True
