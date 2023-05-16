class Solution {
    fun solution(record: Array<String>): Array<String> {
        val user = mutableMapOf<String, String>()
        return record.map{
            val r = it.split(" ")
            when (r[0]) {
                "Enter", "Change" -> user += r[1] to r[2]
            }
            r
        }.asSequence()
            .filter{it[0] != "Change"}
            .map{
                val explanation = when (it[0]) {
                    "Enter" -> "님이 들어왔습니다."
                    "Leave" -> "님이 나갔습니다."
                    else -> {}
                }
                "${user[it[1]]}$explanation"
        }.toList().toTypedArray()
    }
}
