package me.jerrywang.kotlin.study.algorithms.leetcode.dfs

// LC 582
fun killProcess(pid: List<Int>, ppid: List<Int>, kill: Int): List<Int> {
    val map = mutableMapOf<Int, MutableList<Int>>()

    for (i in ppid.indices) {
        if (ppid[i] > 0) {
            val pidList = map.getOrDefault(ppid[i], mutableListOf())

            pidList.add(pid[i])
            map[ppid[i]] = pidList
        }
    }

    val pidList = mutableListOf(kill)

    getAllChildren(map, pidList, kill)

    return pidList
}

fun getAllChildren(map: MutableMap<Int, MutableList<Int>>, pidList: MutableList<Int>, kill: Int) {
    if (map.containsKey(kill)) {
        map[kill]?.let {
            for (pid in it) {
                pidList.add(pid)
                getAllChildren(map, pidList, pid)
            }
        }
    }
}
