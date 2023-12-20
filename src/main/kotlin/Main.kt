package org.example

import org.example.Solutions.FizzBuzz
import org.example.Solutions.ReverseWord

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
            println("Selected : Fizz-Buzz : $selection \n\n")
            FizzBuzz().fizzBuzz()
        }
        2 -> {
            println("Selected : Reverse Word : $selection \n\n")
            ReverseWord().reverseWord("string to be reversed")
        }
    }
}