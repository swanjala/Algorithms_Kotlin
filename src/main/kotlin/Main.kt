package org.example

fun main() {
    println("Enter selection: ")
    val stringInput = readlnOrNull()

    stringInput?.let {
        optionProcessor(it.toInt())
    }
}

private fun optionProcessor(selection: Int) {
    when(selection) {
        1 -> {
            println("Selected : Fizz-Buzz : $selection")
        }
    }
}