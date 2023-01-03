package br.com.emersonmendes.kotstudy.other


fun main(){

    val list = ArrayList<String>()
    list.add("a")
    list.add("b")
    list.add("c")

    val joinToString = list.joinToString()
    println("joinToString: $joinToString")

    val joinToStringFirstTwo = list.getFirstTwo().joinToString()
    println("joinToStringFirstTwo: $joinToStringFirstTwo")

    val a = list.a

    println("a: $a")

}

fun <E> ArrayList<E>.getFirstTwo() : ArrayList<E> {
    return arrayListOf(this[0], this[1])
}

private val <E> List<E>.a: E
    get() = stream().filter { v -> v != null && v == "a" }.findFirst().orElse(null)
