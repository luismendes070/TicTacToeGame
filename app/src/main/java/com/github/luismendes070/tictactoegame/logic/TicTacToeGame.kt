package com.github.luismendes070.tictactoegame.logic

class TicTacToeGame {
    // Game board represented by a 2D array
    private val board = Array(3) { CharArray(3) { ' ' } }

    // Function to check for a win condition
    fun checkWin(player: Char): Boolean {
        // Check for a win in rows, columns, and diagonals
        for (row in 0 until 3) {
            if (checkRowWin(player, row)) {
                return true // Win in a row
            }
            if (checkColumnWin(player, row)) {
                return true // Win in a column
            }
        }
        if (checkMainDiagonalWin(player)) {
            return true // Win in the main diagonal
        }
        if (checkAntiDiagonalWin(player)) {
            return true // Win in the anti-diagonal
        }
        return false
    }

    private fun checkRowWin(player: Char, row: Int): Boolean {
        return board[row][0] == player && board[row][1] == player && board[row][2] == player
    }

    private fun checkColumnWin(player: Char, column: Int): Boolean {
        return board[0][column] == player && board[1][column] == player && board[2][column] == player
    }

    private fun checkMainDiagonalWin(player: Char): Boolean {
        return board[0][0] == player && board[1][1] == player && board[2][2] == player
    }

    private fun checkAntiDiagonalWin(player: Char): Boolean {
        return board[0][2] == player && board[1][1] == player && board[2][0] == player
    }


    // Function to make a move
    fun makeMove(row: Int, col: Int, player: Char) {

        try{

            board[row][col] = player

        }catch (e:Exception){
            e.printStackTrace()
        }finally {

        }

    }
}
