class Solution {
    val words = mutableListOf<String>()
    val wordBundle = listOf("A", "E", "I", "O", "U")
    fun solution(word: String): Int {
        var answer = 0
        backtracking(word, "")
        
        words.forEachIndexed { idx, w ->
            if (w == word) {
                answer = idx
                return@forEachIndexed
            }
            
        }
        
        return answer
    }
    
    fun backtracking(word : String, currentWord : String) {
        if (currentWord.length > 5) return
        words.add(currentWord)
        
        wordBundle.forEach {
            backtracking(word, currentWord + it)
        }
    }
}
