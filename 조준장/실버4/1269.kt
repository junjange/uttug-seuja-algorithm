package implementation


fun main() {
    val (a, b) = readLine()!!.split(" ").map { it.toInt() }
    val aItem = readLine()!!.split(" ").map { it.toInt() }
    val bItem = readLine()!!.split(" ").map { it.toInt() }

    val aMap = mutableMapOf<Int, Int>()
    val bMap = mutableMapOf<Int, Int>()

    var answer = 0

    repeat(a) {
        aMap[aItem[it]] = 1
    }

    repeat(b) {
        bMap[bItem[it]] = 1
    }

    repeat(a) {
        if (bMap[aItem[it]] == null) answer ++
    }

    repeat(b) {
        if (aMap[bItem[it]] == null) answer ++

    }

    println(answer)

}
