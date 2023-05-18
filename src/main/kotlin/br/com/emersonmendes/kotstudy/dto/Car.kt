package br.com.emersonmendes.kotstudy.dto

data class Car (
    val id: Long,
    val color: String,
    val brand: String
) : Comparable<Car> {

    override fun compareTo(other: Car): Int {
        if(id == other.id){
            return 0;
        } else if(id < other.id){
            return -1;
        }
        return 1;
    }

}
