package com.ai.labs

import com.ai.labs.handlers.*
import edu.stanford.nlp.simple.*


fun main() {

//    var sentence = ""
//    while(true) {
//        sentence = readLine()!!
//        if(sentence == "bye") break
//        if(sentence != null && sentence.isNotBlank()) println(questionHandler(sentence))
//
//    }
//        var sentenceString = "Joe Smith was born in California."
//    var sentence = Sentence(sentenceString)

    println("Hello!")
    var sentenceString = ""
    while(true) {
        sentenceString = readLine().toString()
        if(sentenceString.contains("Bye")) {
            println("Bye:)")
            break
        }
        val sentence = Sentence(sentenceString)
        println(defineEntityGroupAndAnswer(sentence))
    }


}
