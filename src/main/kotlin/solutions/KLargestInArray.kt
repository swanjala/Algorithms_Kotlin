package org.example.solutions

import java.util.Arrays

fun IntArray.findKthLargest(k: Int): Int {
    Arrays.sort(this)
    return  this[size - k]
}
