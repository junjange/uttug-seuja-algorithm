package implementation


fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val sb = StringBuilder()

    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val t = br.readLine().split(" ").map { it.toInt() }.toMutableList()

    for (i in 1 until n){
        t[i] += t[i - 1]
    }

    var answer = t[k - 1]

    for (i in 0 until n - k){
        answer = answer.coerceAtLeast(t[i + k] - t[i])
    }

    sb.append(answer.toString())
    bw.write(sb.toString())
    br.close()
    bw.close()

}
