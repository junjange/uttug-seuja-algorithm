class `25760` {
    data class Node(val position: Int = 1, val depth: Int = 0)

    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val n = br.readLine().toInt()
        val graph = MutableList(n + 1) { mutableListOf<Int>() }
        val depthMap = mutableMapOf<Int, Int>()
        val levelCarCount = MutableList(200001) { 0 }

        repeat(n - 1) {
            val (u, v) = br.readLine().split(" ").map { it.toInt() }
            graph[u].add(v)
            graph[v].add(u)
        }

        val queue = ArrayDeque<Node>()

        depthMap[1] = 0
        queue.add(Node())
        while (queue.isNotEmpty()) {
            val target = queue.removeFirst()

            for (i in graph[target.position]) {
                if (i !in depthMap) {
                    depthMap[i] = target.depth + 1
                    queue.addLast(target.copy(position = i, depth = target.depth + 1))
                }
            }
        }

        val deepestLevel = depthMap.values.maxOrNull() ?: 0

        br.readLine().split(" ").map { it.toInt() }.forEachIndexed { index, i ->
            if (i == 1) {
                levelCarCount[depthMap[index + 1] ?: 0] += 1
            }
        }

        var answer = 1
        var frontCarNum = 0
        for (lev in deepestLevel downTo 0) {
            if (levelCarCount[lev] > 0) {
                frontCarNum += levelCarCount[lev]
                answer = maxOf(lev + frontCarNum, answer)
            }
        }

        sb.append(answer)
        bw.write(sb.toString())
        br.close()
        bw.close()
    }


}

fun main() {
    `25760`().solution()
}
