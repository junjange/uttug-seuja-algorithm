fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val sb = StringBuilder()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val books = br.readLine().split(" ").map { it.toInt() }

    val left = mutableListOf<Int>()
    val right = mutableListOf<Int>()

    var answer = 0
    books.forEach {
        if (it < 0) {
            left.add(-it)
        } else {
            right.add(it)
        }
    }

    left.sortDescending()
    right.sortDescending()

    for (i in 0 until left.size step m) {
        answer += left[i] * 2
    }

    for (i in 0 until right.size step m) {
        answer += right[i] * 2
    }

    answer -= (left + right).max()

    sb.append(answer.toString())

    bw.write(sb.toString())
    br.close()
    bw.close()
}
