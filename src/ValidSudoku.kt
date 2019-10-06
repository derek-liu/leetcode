object ValidSudoku {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rowsMap = mutableMapOf<Int, Set<Char>>()
        val columnsMap = mutableMapOf<Int, Set<Char>>()
        val areaMap = mutableMapOf<Int, Set<Char>>()

        for (i in 0 until 9) {
            rowsMap[i] = mutableSetOf()
            columnsMap[i] = mutableSetOf()
            areaMap[i] = mutableSetOf()
        }

        for (i in 0 until board.size) {
            for (j in 0 until board[i].size) {
                if (board[i][j] == '.') continue
                if (rowsMap[i]?.contains(board[i][j]) == true) {
                    return false
                } else {
                    (rowsMap[i] as? MutableSet)?.add(board[i][j])
                }
                if (columnsMap[j]?.contains(board[i][j]) == true) {
                    return false
                } else {
                    (columnsMap[j] as? MutableSet)?.add(board[i][j])
                }
                val areaIndex = (i / 3) * 3 + j / 3
                if (areaMap[areaIndex]?.contains(board[i][j]) == true) {
                    return false
                } else {
                    (areaMap[areaIndex] as? MutableSet)?.add(board[i][j])
                }
            }
        }
        return true
    }

    fun solveSudoku(board: Array<CharArray>): Unit {
        for (i in 0 until board.size) {
            for (j in 0 until board[i].size) {

            }
        }
    }
}