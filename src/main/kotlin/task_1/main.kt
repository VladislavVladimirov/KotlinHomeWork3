package task_1

val scan = java.util.Scanner(System.`in`)
fun printMinutes(time: Int): String {
    val minutes = time / 60
    return if (minutes % 10 == 1) {
        "был(а) $minutes минуту назад"
    } else if (minutes % 10 == 2) {
        "был(а) $minutes минуты назад"
    } else if (minutes % 100 == 11) {
        "был(а) $minutes минут назад"
    } else if (minutes == 60) {
        "был(а) 1 час назад"
    } else {
        "был(а) $minutes минут назад"
    }
}

fun printHours(time: Int): String {
    val hours = time / 3600
    return if (hours % 10 == 1) {
        "был(а) $hours час назад"
    } else if (hours % 10 == 2 || hours % 10 == 3 || hours % 10 == 4) {
        "был(а) $hours часа назад"
    } else {
        "был(а) $hours часов  назад"
    }
}

fun agoToText(time: Int): String {
    return when (time) {
        in 0..60 -> "Был только что"
        in 61..60 * 60 -> printMinutes(time)
        in 3601..24 * 60 * 60 -> printHours(time)
        in (24 * 60 * 60) + 1..48 * 60 * 60 -> "был(а) сегодня"
        in (48 * 60 * 60) + 1..(72 * 60 * 60) -> "был(а) вчера"
        else -> "был(а) давно"
    }
}

fun main() {
    while (true) {
        println("Когда пользователь был онлайн? Введите 1, чтобы ввести время в секундах, 2 чтобы ввести время в минутах, 3 чтобы ввести время в часах. Или введите 0 для завершения программы ")
        val timeMode: Int = scan.nextInt()
        var timeUnits: Int
        if (timeMode == 1) {
            println("Введите количество секунд")
            timeUnits = scan.nextInt()
            println(agoToText(timeUnits))
        } else if (timeMode == 2) {
            println("Введите количество минут")
            timeUnits = (scan.nextInt()) * 60
            println(agoToText(timeUnits))
        } else if (timeMode == 3) {
            println("Введите количество часов")
            timeUnits = (scan.nextInt()) * 3600
            println(agoToText(timeUnits))
        } else if (timeMode == 0) {
            break
        }
    }
}

