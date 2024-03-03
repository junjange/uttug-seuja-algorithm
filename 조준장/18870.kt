fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val m = br.readLine().split(" ").map { it.toInt() }
    val sortedM = m.toSortedSet(compareBy<Int> { it })

    val mapM = sortedM.mapIndexed { idx, i -> i to idx }.toMap()
    val answer = m.map { mapM[it] }

    sb.append(answer.joinToString(" "))

    bw.write(sb.toString())
    br.close()
    bw.close()
}
