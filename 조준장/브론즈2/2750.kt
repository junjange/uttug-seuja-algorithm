package implementation


fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    List(n) { br.readLine().toInt() }.sorted().forEach {
        sb.append("$it\n")
    }

    bw.write(sb.toString())
    br.close()
    bw.close()
}
