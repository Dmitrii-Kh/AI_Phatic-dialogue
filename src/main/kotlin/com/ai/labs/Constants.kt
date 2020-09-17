package com.ai.labs

class Constants {

    companion object {
        private fun read(value: String): String? {
            return PropertyReader.get().readValue(value)
        }

        fun getText(): String? {
            return read("text")
        }
    }
}