object MaxArea {
    fun maxArea(height: IntArray): Int {
        var max = 0
        var left = 0
        var right = height.size - 1
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left))
            if (height[left] < height[right]) {
                left += 1
            } else {
                right -= 1
            }
        }
        return max
    }
}