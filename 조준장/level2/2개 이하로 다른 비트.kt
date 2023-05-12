class Solution {
    fun solution(numbers: LongArray): LongArray = numbers.map { number ->
            if (number.toInt() % 2 == 0) (number+1).toLong()
            else {
                ("0" + number.toString(2)).let{
                    (it.substring(0, it.lastIndexOf('0')) + "10" + it.substring(it.lastIndexOf('0') + 2, it.length)).toLong(2)
                }
            }
        }.toLongArray()
    
}
