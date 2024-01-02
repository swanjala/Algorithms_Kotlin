package org.example.solutions

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



