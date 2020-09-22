package com.ai.labs

import com.ai.labs.handlers.*


fun main() {

    var sentence = ""
    while(true) {
        sentence = readLine()!!
        if(sentence == "bye") { println("See you!"); break }
        if(sentence != null && sentence.isNotBlank()) println(questionHandler(sentence))
    }

}