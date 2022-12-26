package br.com.emersonmendes.kotstudy.other
fun main(){

    val list = ArrayList<String>()
    list.add("a")
    list.add("b")
    list.add("c")

    println(list.joinToString())
    println(list.getFirstTwo().joinToString())

}

fun ArrayList<String>.getFirstTwo() : ArrayList<String> {
    return arrayListOf(this[0], this[1])
}