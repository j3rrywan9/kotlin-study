package me.jerrywang.kotlin.study.algorithms.leetcode.dfs

// LC 200
fun numIslands(grid: Array<CharArray>?): Int {
    if (grid == null || grid.isEmpty()) {
        return 0
    }

    val rows = grid.size
    val cols = grid[0].size
    var numIslands = 0

    for (r in 0 until rows) {
        for (c in 0 until cols) {
            if (grid[r][c] == '1') {
                numIslands++
                dfs(grid, r, c)
            }
        }
    }

    return numIslands
}

fun dfs(grid: Array<CharArray>, row: Int, col: Int) {
    val rows = grid.size
    val cols = grid[0].size

    if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == '0') {
        return
    }

    grid[row][col] = '0'

    dfs(grid, row - 1, col)
    dfs(grid, row + 1, col)
    dfs(grid, row, col - 1)
    dfs(grid, row, col + 1)
}
