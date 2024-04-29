class Solution {
    fun solution(record: Array<String>): Array<String> {
        var answer = arrayOf<String>()
        val mapRecord = mutableMapOf<String, String>()
        record.forEach {
            val recordSplit = it.split(" ")

            if (recordSplit[0] != "Leave") {
                mapRecord[recordSplit[1]] = recordSplit[2]
            }
        }

        record.forEach {
            val recordSplit = it.split(" ")

            when (recordSplit[0]) {
                "Enter" -> answer += "${mapRecord[recordSplit[1]]}님이 들어왔습니다."
                "Leave" -> answer += "${mapRecord[recordSplit[1]]}님이 나갔습니다."
            }

        }

        return answer
    }
}
