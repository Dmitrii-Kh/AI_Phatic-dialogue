package com.ai.labs.handlers

val generalQuestionPrefixes = listOf("am", "is", "are", "do", "did", "does", "was", "were")
val specialQuestionPrefixes = listOf("what", "where", "when", "why", "how", "whose", "whom")


fun defineQuestionType(splittedSentence:List<String>) : String {

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
        "Who" ->  "Me"
        "Alternative" ->  listOfWords.takeLastWhile { it != "or" }.toString().drop(1).dropLast(1)
        else -> "Sorry, I didn`t get you("
    }
}

