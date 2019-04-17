class LengthOfLongestSubstring {
    fun lengthOfLongestSubstring(s: String): Int {
        var startIndex = 0
        var endIndex = 0
        var maxLength = 0
        val map = mutableMapOf<Char, Int>()
        s.forEachIndexed { index, char ->
            if (index == 0) {
                startIndex = 0
                map[char] = index
                maxLength = 1
            } else {
                if (map.containsKey(char) && (map[char] ?: 0) >= startIndex) {
                    maxLength = Math.max(maxLength, index - startIndex)
                    startIndex = (map[char] ?: 0) + 1
                }
                map[char] = index
            }
        }
        maxLength = Math.max(maxLength, s.length - startIndex)
        return maxLength
    }
}