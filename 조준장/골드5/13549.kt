var n = 0
var k = 0
val answer = mutableListOf<Int>()

fun main() {
    val br = System.`in`.buffered().bufferedReader()
    val bw = System.out.buffered().bufferedWriter()
    val sb = StringBuilder()

    val input = br.readLine().split(" ").map { it.toInt() }

    n = input.first()
    k = input[1]

    bfs()
    sb.append(answer.min())
    bw.write(sb.toString())
    br.close()
    bw.close()


}

data class Node(
    val x: Int,
    val depth: Int,
)

fun bfs() {
    val deque = ArrayDeque<Node>()
    deque.add(Node(n, 0))
    val visited = mutableSetOf<Int>()


    while (deque.isNotEmpty()) {
        val (tx, tDepth) = deque.removeFirst()

        if (tx == k) {
            answer.add(tDepth)
            continue
        }


        if (tx - 1 !in visited && 0 <= tx && tx - 1 < 100001) {
            visited.add(tx - 1)
            deque.add(Node(tx - 1, tDepth + 1))

        }

        if (2 * tx !in visited && 0 <= tx && 2 * tx < 100001) {
            visited.add(2 * tx)
            deque.add(Node(tx * 2, tDepth))


        }

        if (tx + 1 !in visited && 0 <= tx && tx + 1 < 100001) {
            visited.add(tx + 1)
            deque.add(Node(tx + 1, tDepth + 1))
        }

    }
}
