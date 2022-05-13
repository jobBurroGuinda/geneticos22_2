package nReynas

import java.util.*


object Mutate {
    fun mutaGen(prob: Double, ind: Individual) {
        // evaluar la probabilidad
        val aux = Math.random()
        if (aux <= prob) {
            // modificar un bit del genotipo
            val ran = Random()
            val posGen = ran.nextInt(ind.genotype.size)
            val posR = ran.nextInt(ind.genotype.size)
            ind.genotype[posGen] = posR
            // actualizamos el fenotipo y el fitness
            ind.updateIndividual()
        }
    }
}
