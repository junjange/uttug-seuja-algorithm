package implementation

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val sb = StringBuilder()

    val a = br.readLine()
    val b = br.readLine()

    val stack = mutableListOf<Char>()

    for (i in a) {
        stack.add(i)

        if (stack.size >= b.length && stack.last() == b.last() && stack.slice(stack.size - b.length until stack.size)
                .joinToString("") == b
        ) {
            repeat(b.length) {
                stack.removeLast()
            }
        }

    }


    if (stack.isEmpty()) sb.append("FRULA")
    else sb.append(stack.joinToString(""))
    bw.write(sb.toString())

    br.close()
    bw.close()
}
