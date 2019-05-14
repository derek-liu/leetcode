object LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        val builder = StringBuilder()
        var result = false
        var c = '#'
        var length = Int.MAX_VALUE
        strs.forEach {
            length = Math.min(length, it.length)
        }

        for (i in 0 until length) {
            strs.forEachIndexed { index, str ->
                if (index == 0) {
                    c = str[i]
                    result = true
                } else {
                    result = result && (c == str[i])
                }
            }
            if (result) {
                builder.append(c)
            } else {
                return builder.toString()
            }
        }

        return builder.toString()
    }
}