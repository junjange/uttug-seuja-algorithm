import java.util.*

class Solution {
    fun solution(p: String): String {
        var answer = ""
        
        return if (`올바른 괄호인지 확인`(p)) p
        else `u와 v로 분리`(p)
    }

    fun `u와 v로 분리`(w : String) : String {
        var left = 0
        var right = 0
        repeat(w.length) {
            if (w[it] == '(') {
                left++
            } else {
                right++
            }
            
            if(left == right) {
                val u = w.substring(0, it + 1)
                val v = w.substring(it + 1, w.length)
                
                if (`올바른 괄호인지 확인`(u)) return u + `u와 v로 분리`(v)
                return "(" + `u와 v로 분리`(v) + ")" +`올바른 문자열 만들기`(u)
            }
        }
        return ""
    }
    
    fun `올바른 괄호인지 확인`(v : String) : Boolean {
        val stack = Stack<String>()
        v.forEach {
            if (stack.isNotEmpty() && stack.last() == "(" && it == ')') {
                stack.pop()
            } else {
                stack.push(it.toString())
            }
        }
        
        return if (stack.isEmpty()) true else false
    }
    
    fun `올바른 문자열 만들기`(u : String) : String {
        var newU = u
        if (newU.length >= 1) {
            newU = newU.drop(1)
        }
        if (newU.length >= 1) {
            newU = newU.dropLast(1)
        }

        var str = ""
        
        newU.forEach {
            if (it == '(') {
                str += ")"
            } else {
                str += "("
            }
        }
        
        return str
    }
}
