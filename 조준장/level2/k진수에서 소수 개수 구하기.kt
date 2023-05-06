import java.math.*

class Solution {
    fun solution(n: Int, k: Int): Int {
        var answer: Int = 0
        n.toString(k)
            .split("0")
            .forEach {
            if (it == "" || it == "0" || it == "1") return@forEach
            if (BigInteger(it).isProbablePrime(1)) answer++
        }
        return answer
    }
}
