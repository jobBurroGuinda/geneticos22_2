package tsp

fun main(){
    val r1 = doubleArrayOf(0.0, 34.5, 22.1, 3.0, 0.7)
    val r2 = doubleArrayOf(34.5, 0.0, 11.0, 45.0, 895.0)
    val r3 = doubleArrayOf(22.1, 11.0, 0.0, 67.6, 333.0)
    val r4 = doubleArrayOf(3.0, 45.0, 67.6, 0.0, 2.0)
    val r5 = doubleArrayOf(0.7, 895.0, 333.0, 2.0, 0.0)

    Tools.distances = arrayOf(r1, r2, r3, r4, r5)

    val i1 = Individual(5, 4)
    val i2 = Individual(5, 0)
    val i3 = Individual(5, 2)
    val i4 = Individual(5, 1)
    val i5 = Individual(5, 3)
    println()
}