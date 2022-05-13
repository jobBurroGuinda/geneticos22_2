package nSat

import java.util.*


object Selection {
    fun tournamentSelection(pob: Population): Individual {
        return Individual(pob.better.genotype)
    }

    fun randomSelection(pob: Population): Individual {
        val ran = Random()
        val pos = ran.nextInt(pob.individuals.size)
        return Individual(
            pob.individuals[pos].genotype
        )
    }
}

