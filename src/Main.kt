import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
suspend fun main() = runBlocking() {
    //TODO 1.	Написать функции getRandomList() создания списков рандомных чисел и
    // символов. Данные функции могут быть перегруженными. Написать функцию распаковки
    // списков unpack(), которые получаем из функций, описанных выше. Она обобщенная,
    // т.е. может принимать список разных типов. Функция выводит в консоль элементы,
    // но все через секундную задержку и в процессе ведет подсчет количества элементов
    // (для имитации длительной работы). Возвращает количество элементов списка.
    //
    //TODO Также есть функция, объединяющая списки в один concatenate(). Учитывайте,
    // что списки могут быть разных типов. Она возвращает объект
    // Pair<Int, MutableList<T>>, где Int – количество элементов объединенного списка,
    // MutableList<T> - сам список.

    //TODO В функции main:
    //
    //TODO 1.	Получить списки целых чисел и символов с помощью функций
    // getRandomList(), состоящие из 10 элементов.
    // 2.	Оба списка необходимо асинхронно распаковать.
    // 3.	Вывести в консоль общий размер полученного списка.
    // 4.	Объединить их функцией concatenate() и вывести в консоль полученный список.
    // 5.	Посчитать общее время затраченных операций.
    println("1. Задание\n")
    val decoration = Decoration()

    val time = measureTimeMillis {

        val randomInt = getRandomList(10, 1)
        val randomChar = getRandomList(10, 'c')

        val oneList = async { unpack(randomInt) }
        val twoList = async { unpack(randomChar) }

        oneList.join()
        twoList.join()

        val concatenate =
            concatenate(randomInt, randomChar)

        println("\nОбщий размер полученного списка: ${concatenate.first}\n")
        println("Общий список загруженных элементов:\n${concatenate.second}\n")
    }
    println("Затрачено времени: $time мс")

    decoration.getLine("=")
}