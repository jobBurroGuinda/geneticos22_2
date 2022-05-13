
import nSat.GeneticNSAT
import nSat.Tokenizer.leerDatos

fun main() {
    leerDatos()
    val gen = GeneticNSAT(1000000, 80, 0.25)
    gen.evolve()
    println()
}
