fun main(args: Array<String>) {
    var r = Rectangle(10, 10)

    println("Hello world: " + r.isSq())

    var str: String = "Hello"
    println(str.lastChar())


    var a = 6
    var b = 3

    var op = operation('+');
    println(op(a, b))

    op = operation('-');
    println(op(a, b))

    op = operation('*');
    println(op(a, b))

    op = operation('/');
    println(op(a, b))

    val words = listOf("Lets", null, "something", "in", "collection", "somehow")  // 1

    val first = words.find { it?.startsWith("some") ?: false}
    println(first)
}

fun String.lcase(): String {
    return this.toLowerCase();
}


fun operation(c : Char): (Int , Int) -> Int = when(c) {
    '+' -> ::add
    '-' -> ::sub
    '*' -> ::mul
    '/' -> ::div
    else -> ::nop
}

fun max(a: Int, b: Int): Int = if(a>b) a else b

fun add(a: Int, b: Int) = a + b
fun sub(a: Int, b: Int) = a - b
fun mul(a: Int, b: Int) = a * b
fun div(a: Int, b: Int) = a / b

fun nop(a: Int, b: Int) = 0

class Rectangle(val height: Int, val width: Int) {
    private val isSquare: Boolean
        get() {
            return height == width
        }

    fun isSq() = isSquare
}

fun test() {
    val list = arrayListOf(1, 7, 53)
    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
}

