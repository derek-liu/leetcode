object Hanota {
    fun hanota(n: Int) {
        move(n, "a", "b", "c")
    }

    private fun move(n: Int, a: String, b: String, c: String) {
        println("n:$n $a $b $c")
        if (n == 1) {
            println("$a -> $c")
            return
        }
        move(n - 1, a, c, b)
        println("$a -> $c")
        move(n - 1, b, a, c)
    }
}