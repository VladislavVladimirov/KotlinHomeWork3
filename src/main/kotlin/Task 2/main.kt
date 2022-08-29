package `Task 2`

fun calculateTax(type: Int, sum: Int, previousSum: Int): Double {
    return when (type) {
        1 -> {
            val percentMastercard = 0.006
            val tax = (sum * percentMastercard) + 2000
            return if (previousSum < 7_500_000) {
                0.0
            } else {
                tax
            }
        }
        2 -> {
            val percent = 0.0075
            val tax = sum * percent
            return if (tax < 3500) {
                3500.0
            } else {
                tax
            }
        }
        else -> 0.0
    }
}

fun main() {
    val vkPaySumLimit = 1_500_000
    val vkPayMonthLimit = 4_000_000
    val cardDailyLimit = 15_000_000
    val cardMonthLimit = 60_000_000
    var previousSumVK = 0
    var previousSumMastercard = 0
    var previousSumVisa = 0
    var previousSumVisaPrint = 0
    var previousSumVKPrint = 0
    var previousSumMastercardPrint = 0
    while (true) {
        println(
            "Выберите тип платежной системы для перевода:" +
                    "\n1. VK Pay" +
                    "\n2. Mastercard или Maestro" +
                    "\n3. Visa или МИР" +
                    "\nДля завершения программы введите `0`"
        )
        try {
            val inputType = readLine()
            when (Integer.parseInt(inputType)) {
                1 -> {
                    println("Введите сумму перевода")
                    val inputSum = readLine()
                    val sum = (Integer.parseInt(inputSum)) * 100
                    val sumPrint = sum / 100
                    if (sum <= vkPaySumLimit && (previousSumVK + sum) <= vkPayMonthLimit) {
                        previousSumVK += sum
                        previousSumVKPrint = previousSumVK / 100
                        println(
                            "Cумма перевода: $sumPrint рублей" +
                                    "\nКомиссия: 0 рублей\nВсего за месяц: $previousSumVKPrint\n"
                        )
                    } else if (sum > vkPaySumLimit) {
                        println(
                            "Сумма перевода: $sumPrint рублей" +
                                    "\nСумма не должна превышать 15000 рублей\n"
                        )
                    } else if (previousSumVK + sum > vkPayMonthLimit) {
                        println(
                            "Cумма совершенных переводов за этот месяц: $previousSumVKPrint" +
                                    "\nПеревод невозможен, вы превысите максимальную сумму переводов за месяц в размере 40000 рублей" +
                                    "\nПопробуйте уменьшить сумму перевода\n"
                        )
                    }
                }
                2 -> {
                    println("Введите сумму перевода")
                    val inputSum = readLine()
                    val sum = (Integer.parseInt(inputSum)) * 100
                    val sumPrint = sum / 100
                    val tax = calculateTax(1, sum, previousSumMastercard)
                    val taxPrint = tax / 100
                    if (sum <= cardDailyLimit && (previousSumMastercard + sum) <= cardMonthLimit) {
                        previousSumMastercard += sum
                        previousSumMastercardPrint = previousSumMastercard / 100
                        println(
                            "Cумма перевода: $sumPrint рублей" +
                                    "\nКомиссия: $taxPrint рублей\nВсего за месяц: $previousSumMastercardPrint\n"
                        )
                    } else if (sum > cardDailyLimit) {
                        println(
                            "Сумма перевода: $sumPrint рублей" +
                                    "\nСумма переводов не должна превышать 150000 рублей в сутки\n"
                        )
                    } else if (previousSumMastercard + sum > cardMonthLimit) {
                        println(
                            "Сумма совершенных переводов за этот месяц: $previousSumMastercardPrint" +
                                    "\nПеревод невозможен, вы превысите максимальную сумму переводов за месяц в размере 600000 рублей" +
                                    "\nПопробуйте уменьшить сумму перевода\n"
                        )
                    }

                }
                3 -> {
                    println("Введите сумму перевода")
                    val inputSum = readLine()
                    val sum = (Integer.parseInt(inputSum)) * 100
                    val sumPrint = sum / 100
                    val tax = calculateTax(2, sum, previousSumVisa)
                    val taxPrint = tax / 100
                    if (sum <= cardDailyLimit && (previousSumVisa + sum) <= cardMonthLimit) {
                        previousSumVisa += sum
                        previousSumVisaPrint = previousSumVisa / 100
                        println(
                            "Cумма перевода: $sumPrint рублей" +
                                    "\nКомиссия: $taxPrint рублей\nВсего за месяц: $previousSumVisaPrint\n"
                        )
                    } else if (sum > cardDailyLimit) {
                        println(
                            "Сумма перевода: $sumPrint рублей" +
                                    "\nСумма переводов не должна превышать 150000 рублей в сутки\n"
                        )
                    } else if (previousSumVisa + sum > cardMonthLimit) {
                        println(
                            "Сумма совершенных переводов за этот месяц: $previousSumVisaPrint" +
                                    "\nПеревод невозможен, вы превысите максимальную сумму переводов за месяц в размере 600000 рублей" +
                                    "\nПопробуйте уменьшить сумму перевода\n"
                        )
                    }
                }
                0 -> break
                else -> {
                    println("Неправильный номер команды\n")
                }
            }
        } catch (NumberFormatException: Exception) {
            println("Неверная команда\n")
        }
    }
}

