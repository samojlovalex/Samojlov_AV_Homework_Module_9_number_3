import kotlinx.coroutines.delay

fun getRandomList(length: Int, char: Char): List<Char> {
    val charList = ('A'..'Z') + ('a'..'z')
    return (1..length).map { charList.random() }.toList()
}

fun getRandomList(length: Int, int: Int): List<Int> {
    val numberList = (0..9)
    return (1..length).map { numberList.random() }.toList()
}

suspend fun <T> unpack(list: List<T>) {
    var k = 1
    for (element in list) {
        delay(1000L)
        println("Загружен ${k++} элемент списка: $element")
    }
}

fun <T> concatenate(listOne: List<T>, listTwo: List<T>): Pair<Int, MutableList<T>> {
    val listOut = listOne.toMutableList()
    listOut.addAll(listTwo)
    val concatenate =
        Pair(listOut.size, listOut)
    return concatenate
}