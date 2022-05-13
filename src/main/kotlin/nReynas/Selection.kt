package nReynas

import java.util.*


object Selection {
    fun tounamentSelection(pob: Population): Individual {
        return Individual(pob.better.genotype)
    }

    fun randomSelection(pob: Population): Individual {
        val ran = Random()
        val pos = ran.nextInt(pob.individuals.size)
        return Individual(
            pob.individuals[pos].genotype
        )
    }

    enum class SelectionType {
        RANDOM, TOURNAMENT
    }

    enum class TipoMuestreo {
        BETTER
    }
}
