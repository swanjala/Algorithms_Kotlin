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

class Node(
    var value: Int,
    var leftChild: Node? = null,
    var rightChild: Node? = null
) {
    fun insert(element: Int) {
        if (element > this.value) {
            if (this.rightChild == null) {
                this.rightChild = Node(element)
            } else {
                this.rightChild?.insert(element)// recursive insertion
            }
        } else if (element < value) {
            if (this.leftChild == null) {
                this.leftChild = Node(element)
            } else {
                this.leftChild?.insert(element) // recursive insertion
            }
        }
    }

    fun find(element: Int): Node? = when {
        this.value > element -> leftChild?.find(element)
        this.value < element -> rightChild?.find(element)
        else -> this
    }

    fun delete(element: Int) {
        when {
            element > value -> {
                scan(element, this.rightChild, this)
                println("Deleted from left subtree")
            }

            else -> {
                removeNode(this, null)
                println("Deleted nothing")
            }
        }
    }

    private fun scan(element: Int, node: Node?, parent: Node?) {
        if (node == null) {
            println("Does not exist")
            return
        }
        when {
            element > node.value -> scan(element, node.rightChild, node)
            element < node.value -> scan(element, node.leftChild, node)
            element == node.value -> removeNode(node, parent)
        }
    }

    private fun removeNode(node: Node, parent: Node?) {
        node.leftChild?.let { left ->
            run {
                node.rightChild?.let {
                    removeTwoChildren(node)
                } ?: removeOneChild(node, left)
            }
        } ?: run {
            node.rightChild?.let { right -> removeOneChild(node, right) }
        } ?: removeNone(node, parent)
    }

    private fun removeNone(node: Node, parent: Node?) {
        parent?.let { parentNode ->
            if (node == parentNode.leftChild) {
                parentNode.leftChild = null
            } else if (node == parentNode.rightChild) {
                parentNode.rightChild = null
            }
        } ?: throw IllegalStateException("Cannot remove")
    }

    private fun removeOneChild(parent: Node, child: Node) {
        parent.value = child.value
        parent.leftChild = child.leftChild
        parent.rightChild = child.rightChild
    }

    private fun removeTwoChildren(node: Node) {
        val left = node.leftChild
        left?.rightChild?.let {
            val maximumParent = findParentOfMaxChild(left)
            maximumParent
        }
    }

    private fun findParentOfMaxChild(node: Node): Node {
        return node.rightChild?.let { right ->
            right.rightChild?.let {
                findParentOfMaxChild(right)
            } ?: node
        } ?: throw IllegalArgumentException("right child is null")
    }
}

fun main(args: Array<String>) {
    val tree = Node(60)
    val elements = arrayOf(30, 33, 40, 20, 30, 125, 70, 90, 6)

    for (element in elements) {
        tree.insert(element)
    }

    val node = tree.find(125)

    println(node)

    val deleted = tree.delete(125)

    // Deleted node
    println(deleted)

    // Selected node

    node?.let {
        println(it.value)
    }
}
