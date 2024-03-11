class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer: Int = 0
        val n = number.sumOf{ it }
        val newDiscount = discount.toMutableList()

        for (i in 0 .. discount.size - n){
            var cnt = 0
            want.forEachIndexed{ index, w ->
                if(newDiscount.subList(i, i + n).count{ it == w } == number[index]) {
                    cnt ++
                }
            }

            if (want.size == cnt) answer++
        }

        return answer
    }
}
