package org.example.Solutions


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
