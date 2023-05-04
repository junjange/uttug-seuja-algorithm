import java.util.Stack

class Solution {
    
    val openBracket = listOf('(', '[', '{')
    
    fun solution(s: String): Int {
        var answer = 0
        var str = s
        
        s.forEach{
            if(cheack(str)) answer++
            str = rotate(str)
        }

        return answer
    }
    
    fun rotate(s : String) : String = s.substring(1, s.length) + s[0]
    
    fun cheack(s : String) : Boolean {
        val newStack = Stack<Char>()
        
        s.forEach {
            when {
                openBracket.contains(it) -> newStack.add(it)
                newStack.isEmpty() -> return false
                it == ')' -> if(newStack.pop() != '(') return false
                it == ']' -> if(newStack.pop() != '[') return false
                it == '}' -> if(newStack.pop() != '{') return false
            }
        }
        return if(newStack.isEmpty()) true else false
    }
    
    
}
