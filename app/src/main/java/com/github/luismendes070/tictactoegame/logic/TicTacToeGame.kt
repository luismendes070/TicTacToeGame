package com.github.luismendes070.tictactoegame.logic

class TicTacToeGame {
    // Game board represented by a 2D array
    private val board = Array(3) { CharArray(3) { ' ' } }

    // Function to check for a win condition
    fun checkWin(player: Char): Boolean {
        // Check rows, columns, and diagonals
        for (i in 0 until 3) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true // Win in a row
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true // Win in a column
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true // Win in the main diagonal
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true // Win in the anti-diagonal
        }
        return false
    }

    // Function to make a move
    fun makeMove(row: Int, col: Int, player: Char) {
        board[row][col] = player
    }
}
