package com.ai.labs.handlers

import com.ai.labs.answerTemplates.names
import com.ai.labs.answerTemplates.noAnswer

val generalQuestionPrefixes = listOf("am", "is", "are", "do", "did", "does", "was", "were")
val specialQuestionPrefixes = listOf("what", "where", "when", "why", "how", "whose", "whom")


private fun defineQuestionType(splittedSentence:List<String>) : String {

    val questionWord = splittedSentence[0].toLowerCase()
    return when {
        questionWord in specialQuestionPrefixes ->  "Special"
        questionWord == "who" -> "Who"
        questionWord in generalQuestionPrefixes && splittedSentence.contains("or") -> "Alternative"
        questionWord in generalQuestionPrefixes -> "General"
        else -> "Tag"
    }
}

fun questionHandler(sentence : String) : String {
    var sentence = sentence.subSequence(0, sentence.length-1)
    val listOfWords = sentence.split(" ")
    val type = defineQuestionType(listOfWords)

    return when(type) {
        "General" -> listOf("Yes", "No").random()
        "Who" ->  listOf("It`s me", "I thing it`s you", "My friend " + names.random(), noAnswer.random()).random()
        "Alternative" ->  listOfWords.takeLastWhile { it != "or" }.toString().drop(1).dropLast(1).replace(", ", " ")
        "Special" -> noAnswer.random()
        "Tag" -> noAnswer.random()
        else -> "Sorry, I didn`t get you("
    }
}
