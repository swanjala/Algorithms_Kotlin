package org.example.solutions

import java.util.Arrays


/*
* Given an array, rotate the array to the left by k steps,
* where k is non-negative
* Input: [1,2,3,4,5,6,7] and k=2
* Output: [3,4,5,6,7,1,2]
* */
fun IntArray.leftShift(k: Int): IntArray {
    val shiftedArray = this.copyOf()
    var rotateBy = k

    if (rotateBy > size) {
        rotateBy %= size
    }

    forEachIndexed { index, value ->
        val shiftedIndex = (index + (size - rotateBy)) % size
        shiftedArray[shiftedIndex] = value
    }

    return shiftedArray
}

/*print the numbers from 1 to 200,
* and for multiple of 3 print "Fizz" instead of the number and for the multiples of 5
* print "Buzz"*/

class FizzBuzz {
    fun fizzBuzz () {
        println(
            (1..200).map {index ->
                mapOf(
                    0 to index,
                    index % 3 to "Fizz",
                    index % 5 to "Buzz",
                    index % 15 to "Fizz Buzz"
                )[0]
            }
        )
    }
}

fun IntArray.findKthLargest(k: Int): Int {
    Arrays.sort(this)
    return  this[size - k]
}


/*
* given a 2D matrix, if an element is 0,
* set its entire row and column to 0. Do it in place.
*
*Input:
* [[1,1,1,1]
* [1,1,1,0]
* [1,1,1,1]]
*
* Output:
* [[1,1,1,0]
* [0,0,0,0]
* [1,1,1,0]
* */

fun Array<IntArray>.setMatrixZero() {
    with(this) {
        val rows = size
        val columns = get(0).size // Get the number of values in each row

        var firstRow = false
        var firstCol = false

        for(row in 0 until rows) {
            for(col in 0 until columns) {
                if(get(row)[col] == 0) {
                    if(row == 0) {
                        firstRow = true
                    }
                    if(col == 0) {
                        firstCol = true
                    }
                    get(row)[0] = 0
                    get(0)[col] = 0
                }
            }
        }

        for(row in 1 until rows) {
            if(this[row][0] == 0) {
                for(col in 1 until columns) {
                    get(row)[col] = 0
                }
            }
        }

        for(col in 1 until columns) {
            if(this[0][col] == 0) {
                for(row in 1 until  rows) {
                    get(row)[col] = 0
                }
            }
        }

        if(firstRow) {
            for(col in 0 until columns) {
                get(0)[col] = 0
            }
        }

        if(firstCol) {
            for(row in 0 until rows) {
                get(row)[0] = 0
            }
        }
    }
}

/*
* Given an input string, reverse the string word for word
* Input: "Reverse words in a string
* Output: String a in words reverse*/

fun String.reverseSentence() =
    this.split(" ")
        .reversed()
        .joinToString(" ")


/*
* Input:
* [[1,2,3,4],
* [5,6,7,8],
* [9,10,11,12],
* [13,14,15,16]]
*
* Output: 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10*/

fun Array<IntArray>.spiralMatrix(): List<Int> = with(this) {


    if (isEmpty() || get(0).isEmpty()) {
        return listOf() // return empty list.
    }

    val numberOfElements = size * get(0).size
    val matrixIntSpiralOrder = ArrayList<Int>(numberOfElements)

    val printedElements = Array(size) {
        BooleanArray(get(0).size)
    }

    if (size == 1) {
        get(0).mapTo(matrixIntSpiralOrder) {
            it
        }
        return matrixIntSpiralOrder
    }

    if (get(0).size == 1) {
        mapTo(matrixIntSpiralOrder) {
            it[0]
        }

        return matrixIntSpiralOrder
    }

    val middleX = if (size % 2 == 0) {
        (size - 1) / 2
    } else {
        size / 2
    }

    val middleY = if (get(0).size % 2 == 0) {
        (get(0).size - 1) / 2
    } else {
        get(0).size / 2
    }

    var row = 0
    var col = 0
    var depth = 0

    while (row <= middleX && col <= middleY && depth <= middleX && depth <= middleY) {
        row = depth
        col = depth

        while (col < get(0).size - depth) {
            if (!printedElements[row][col]) {
                matrixIntSpiralOrder.add(get(row)[col])
                printedElements[row][col] = true
            }
            col++
        }
        col--
        row++

        while (row < size - depth) {
            if (!printedElements[row][col]) {
                matrixIntSpiralOrder.add(get(row)[col])
                printedElements[row][col] = true
            }

            row++
        }

        row--
        col--

        while (col >= depth) {
            if (!printedElements[row][col]) {
                matrixIntSpiralOrder.add(get(row)[col])
                printedElements[row][col] = true
            }
            col--
        }

        col++
        row--

        while (row > depth) {
            if (!printedElements[row][col]) {
                matrixIntSpiralOrder.add(get(row)[col])
                printedElements[row][col] = true
            }
            row--
        }
        depth++
    }

    return matrixIntSpiralOrder

}
