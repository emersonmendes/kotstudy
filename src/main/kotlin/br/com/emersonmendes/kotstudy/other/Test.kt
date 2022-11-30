fun main(args: Array<String>){

    showHello( "Emerson", sureName = "Mendes")

    readFile()



}

fun showHello(name: String, sureName: String){
    val values = mutableMapOf<String, String>()
    values["a"] = "1"
    println("Hello $name $sureName")
    println(values["a"]?.toString())
}