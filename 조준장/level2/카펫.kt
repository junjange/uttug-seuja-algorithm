class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        val width : Int = ((brown - 4) / 2).toInt()
        return (1..yellow+1).first{
            ((width - it) * it == yellow)}.let{
            intArrayOf(width - it + 2 , it + 2)
        }    
    }
}
