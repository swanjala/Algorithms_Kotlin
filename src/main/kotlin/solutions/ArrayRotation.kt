package org.example.solutions

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
// todo right shift.