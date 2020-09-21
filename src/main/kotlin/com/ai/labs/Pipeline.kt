package com.ai.labs

import edu.stanford.nlp.pipeline.StanfordCoreNLP
import java.util.*


class Pipeline {
    companion object {
        private val properties = Properties()
        private val propertiesName: String
            get() {
                return propertiesName
            }
        private val stanfordCoreNLP: StanfordCoreNLP?
            get() {
                return stanfordCoreNLP ?: StanfordCoreNLP(properties)
            }
    }
    init {
        properties.setProperty("annotators", propertiesName)
    }

}