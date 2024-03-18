class Solution {
    fun solution(
        number: String,
        k: Int,
    ): String {
        var answer = ""
        var kk = k
        val n =
            number.map {
                it.toString().toInt()
            }

        val stack = ArrayDeque<Int>()

        for (i in 0 until n.size) {
            if (stack.isNotEmpty() && stack.last() < n[i]) { 
                while (stack.isNotEmpty()) {
                    if (kk == 0) break

                    if (stack.last() < n[i]) {
                        stack.removeLast()
                        kk -= 1
                    } else {
                        break
                    }
                }
                stack.add(n[i])
                
            } else {
                stack.add(n[i])
            }
        }
        
        if (kk != 0){
          repeat(kk) {
              stack.removeLast()
          }  
        }
        
        return stack.joinToString("")
    }
}
