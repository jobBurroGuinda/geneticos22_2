package tsp

import java.util.*


object Mutate {
    fun mutaGen(prob: Double, ind: Individual) {
        val aux = Math.random()
        if (aux <= prob) {
            // modificar un bit del genotipo
            val ran = Random()
            val posGen = ran.nextInt(ind.genotype.size - 1) + 1
            val value = ind.genotype[posGen]
            val posGen2 = ran.nextInt(ind.genotype.size - 1) + 1
            ind.genotype[posGen] = ind.genotype[posGen2]
            ind.genotype[posGen2] = value
            // actualizamos el fenotipo y el fitness
            ind.updateIndividual()
        }
    }
}
