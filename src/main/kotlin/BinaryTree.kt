package org.example

/*
   Build a binary tree data structure

              60
           /     \
          30      125
         / \      / \
        33 40    70 90
       /  \     /
      20  30   6
*/

class Node (
    var value: Int,
    var leftChild: Node? = null,
    var rightChild: Node? = null
){
    fun insert(element: Int) {
        if(element > this.value) {
            if(this.rightChild == null) {
                this.rightChild = Node(element)
            } else {
                this.rightChild?.insert(element)// recursive insertion
            }
        } else if(element < value) {
            if(this.leftChild == null) {
                this.leftChild = Node(element)
            }
            else {
                this.leftChild?.insert(element) // recursive insertion
            }
        }
    }

    fun find(element: Int): Node? = when {
        this.value > element -> leftChild?.find(element)
        this.value < element -> rightChild?.find(element)
        else -> this
    }
}

fun main(args: Array<String>) {
    val tree = Node(60)
    val elements = arrayOf(30, 33, 40, 20, 30, 125, 70, 90, 6)

    for(element in elements) {
        tree.insert(element)
    }

    val node = tree.find(125)

    node?.let {
        println(it.value)
    }
}