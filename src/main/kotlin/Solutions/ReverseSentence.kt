package org.example.Solutions

/*
* Given an input string, reverse the string word for word
* Input: "Reverse words in a string
* Output: String a in words reverse*/

fun String.reverseSentence() =
    this.split(" ")
        .reversed()
        .joinToString(" ")
