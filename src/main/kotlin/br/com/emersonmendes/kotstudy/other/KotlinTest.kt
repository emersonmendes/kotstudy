package br.com.emersonmendes.kotstudy.other

import java.util.Map

object KotlinTest {

    private const val text = "Hello World"
    private val texts: MutableMap<Int, String> = HashMap()
    private val texts2 = Map.of(0, "Hello Friend")

    @JvmStatic
    fun main(args: Array<String>) {
        showHelloWorld()
    }

    private fun showHelloWorld() {
        texts[1] = "Hello Emerson"
        texts[2] = "Hello Bob"
        texts[3] = "Hello Kimany"
        println(text)
        println(texts2[0])
        println(texts[1])
        println(texts[2])
        println(texts[3])
    }

}