class Solution {
    val alphabet = arrayListOf("A", "E", "I", "O", "U")
    val words = ArrayList<String>()
    
    fun solution(word: String): Int {
        var answer = 0
        dfs("")
        words.indices.forEach{
            if (words[it] == word){
                answer = it
                return@forEach
                
            } 
        }
        return answer
    }
    
    fun dfs(word : String){
        if (word.length > 5) return
        words.add(word)
        
        alphabet.forEach{
            dfs(word+it)
        }
    }
    
    
}
