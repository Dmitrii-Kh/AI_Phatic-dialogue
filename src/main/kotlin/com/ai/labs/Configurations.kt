package com.ai.labs

class Configurations {

    companion object {
        private fun read(value: String): String? {
            return PropertyReader.get().readValue(value)
        }

        fun getText(): String? {
            return read("text")
        }
        fun getPersonAnswerTemplates() : String? {
            return read("personAnswerTemplates")
        }
    }
}