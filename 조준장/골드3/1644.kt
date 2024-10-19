class `1644` {
    fun solution() {
        val br = System.`in`.bufferedReader()
        val bw = System.out.bufferedWriter()
        val sb = StringBuilder()

        val n = br.readLine().toInt()
        val primes = findPrimes(n)
        var answer = 0

        var result = 0
        var start = 0
        for (end in 0 until primes.size) {
            result += primes[end]

            while (true) {
                if (result <= n) break
                result -= primes[start]
                start++
            }

            if (result == n) answer++

        }

        sb.append(answer)
        bw.write(sb.toString())
        br.close()
        bw.close()
    }

    fun findPrimes(n: Int): List<Int> {
        val isPrime = BooleanArray(n + 1) { true }
        isPrime[0] = false
        isPrime[1] = false

        for (i in 2..Math.sqrt(n.toDouble()).toInt()) {
            if (isPrime[i]) {
                for (j in i * i..n step i) {
                    isPrime[j] = false
                }
            }
        }

        return (2..n).filter { isPrime[it] }
    }
}

fun main() {
    `1644`().solution()
}
