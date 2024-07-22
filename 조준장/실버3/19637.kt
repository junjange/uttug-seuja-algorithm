fun main() {
    val br = System.`in`.buffered().bufferedReader()
    val bw = System.out.buffered().bufferedWriter()
    val sb = StringBuilder()

    val (n, m) = br.readLine().split(" ")


    val styles = List(n.toInt()) {
        br.readLine().split(" ")
    }

    val powers = List(m.toInt()) {
        br.readLine().toInt()
    }

    powers.forEach { power ->
        var left = 0
        var right = styles.size
        var result = 0

        while (left <= right) {
            val mid = (left + right).div(2)

            if (styles[mid][1].toInt() >= power) {
                result = mid
                right = mid - 1
            } else {
                left = mid + 1
            }

        }

        sb.append(styles[result][0] + "\n")
    }

    bw.write(sb.toString().dropLast(1))

    bw.close()
    br.close()

}
