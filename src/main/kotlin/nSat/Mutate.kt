package nSat

import java.util.*


object Mutate {
    fun mutaBit(prob: Double, ind: Individual) {
        // evaluar la probabilidad
        val aux = Math.random()
        if (aux <= prob) {
            // modificar un bit del genotipo
            val ran = Random()
            val pos = ran.nextInt(ind.genotype.size)
            if (ind.genotype[pos] == 1) {
                ind.genotype[pos] = 0
            } else {
                ind.genotype[pos] = 1
            }
            // actualizamos el fenotipo y el fitness
            ind.updateIndividual()
        }
    }
}
