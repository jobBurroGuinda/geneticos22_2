package equisCuadrada

import java.util.*


object Seleccion {
    fun seleccionTorneo(pob: Poblacion): Individual {
        return Individual(pob.better.genotype)
    }

    fun seleccionAleatoria(pob: Poblacion): Individual {
        val ran = Random()
        val pos = ran.nextInt(pob.indivduals.size)
        return Individual(
            pob.indivduals[pos].genotype
        )
    }
}

