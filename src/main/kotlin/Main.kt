package org.example

import java.util.LinkedList
import java.util.Queue


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

            for (element in rotatedArray) {
                println(element.toString())
            }
        }

        4 -> {
            println("Selected : Array Rotation : $selection \n\n")
            print(
                intArrayOf(2, 3, 1, 4, 5).findKthLargest(2)
            )
        }

        5 -> {
            println("Selected : Set Matrix Zero : $selection \n\n")

            val inputArray = arrayOf(
                intArrayOf(1, 1, 1),
                intArrayOf(1, 0, 1),
                intArrayOf(1, 1, 1),
            )
            inputArray.setMatrixZero()

            println(inputArray.map { it ->
                it.toList()
            })
        }

        6 -> {
            println("Selected : Spiral Matrix : $selection \n\n")


            val inputArray = arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(4, 5, 6),
                intArrayOf(7, 8, 9),
            ).spiralMatrix()

            println(inputArray.toString())

        }

        7 -> {
            println("Selected : Queue with linkedList : $selection \n\n")
            val queue: Queue<String> = LinkedList<String>()

            queue.add("Apple")
            queue.add("Orange")
            queue.add("Banana")
            queue.add("Peaches")

            println(queue)
            println(queue.isEmpty())
            println(queue.size)

            val apple = "Apple"
            if (queue.contains(apple)) {
                println("Queue $queue contains $apple")
            } else {
                println("Queue doesn't contain $apple")
            }

            val firstElement1 = queue.peek()

            println("First: $firstElement1")

            // todo add other queue ops

        }

        else -> {
            println("Select only 1 to 6")
        }
    }
}
