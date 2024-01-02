package org.example

import org.example.Solutions.*
import org.example.solutions.findKthLargest
import org.example.solutions.leftShift
import org.example.solutions.reverseSentence
import org.example.solutions.setMatrixZero

fun main() {
    println("Enter selection: ")
    val stringInput = readlnOrNull()

    stringInput?.let {
        optionProcessor(it.toInt())
    }
}

private fun optionProcessor(selection: Int) {
    when (selection) {
        1 -> {
            println("Selected : Fizz-Buzz : $selection \n\n")
            FizzBuzz().fizzBuzz()
        }

        2 -> {
            println("Selected : Reverse Word : $selection \n\n")
            println(("string to be reversed").reverseSentence())
        }

        3 -> {
            println("Selected : Array Rotation : $selection \n\n")
            val rotatedArray = intArrayOf(1, 2, 3, 4, 5, 6, 7).leftShift(2)

            for(element in rotatedArray){
                println(element)
            }
        }

        4 -> {
            println("Selected : Array Rotation : $selection \n\n")
            println(
                intArrayOf(2,3,1,4,5).findKthLargest(2)
            )
        }

        5 -> {
            println("Selected : Set Matrix Zero : $selection \n\n")

            val inputArray = arrayOf(
                intArrayOf(1,1,1),
                intArrayOf(1,0,1),
                intArrayOf(1,1,1),
            )
           inputArray.setMatrixZero()

            println(inputArray.map { it ->
                it.toList()
            })
        }
    }
}
