import br.com.emersonmendes.kotstudy.dto.Car

fun main(args: Array<String>){

    showHello( "Emerson", sureName = "Mendes")
    readFile()

    val carSet = sortedSetOf(
        Car(2,"fusca", "blue"),
        Car(20,"porsche", "yellow"),
        Car(1, "ferrari", "red")
    )

    println(carSet)

}

fun showHello(name: String, sureName: String){
    val values = mutableMapOf<String, String>()
    values["a"] = "1"
    println("Hello $name $sureName")
    println(values["a"]?.toString())
}