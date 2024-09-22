import kotlin.math.pow

class `31927` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val n = br.readLine().toInt()
        val arr = br.readLine().split(" ").map { it.toInt() }.toMutableList()

        val maxCount = n / 2
        sb.append("$maxCount\n")
        repeat(maxCount) {
            val target = 10.toFloat().pow(6).toInt() - (5000 * it)
            arr[it] += target
            arr[n - it - 1] -= target
            sb.append("${arr.joinToString(" ")}\n")
        }

        val sortedArr = arr.sortedDescending()
        if (arr != sortedArr) {
            bw.write("-1")
        } else {
            bw.write(sb.dropLast(1).toString())
        }

        br.close()
        bw.close()
    }
}

fun main() {
    `31927`().solution()
}

//5
//100 40 50 60 10

//100 40 50 60 70 10

// 100 70 50 60 40 10

// 100 60 50 60 -20
// 100 60 50 50 -30


// 100 50 50 50 10

// 150 40 50 10 10
// 160 40 40 10 10


//5
//30 70 50 60 10
// 71 70 50 19 10

//4
//5 2 2 -1

// 1 2 3 4
// 5 2 3
