package equisCuadrada

import java.util.*


class Poblacion {
    var indivduals: ArrayList<Individual>
        private set

    constructor(numInd: Int) {
        indivduals = ArrayList()
        for (x in 0 until numInd) indivduals.add(Individuo())
    }

    constructor(aux: ArrayList<Individual?>) {
        indivduals = aux.clone() as ArrayList<Individual>
    }

    fun getNMejores(n: Int): ArrayList<Individual> {
        // validar que n <= tamaño de la población
        if (n < indivduals.size) {
            // ordenar a la población
            ordenarPoblacionActual()
            // creamos un coleccion nueva de individuos
            val muestra = ArrayList<Individual>()
            for (x in indivduals.size - 1 downTo indivduals.size - n) {
                val e = Individual(indivduals[x].genotype)
                muestra.add(e)
            }
            return muestra
        }
        return indivduals.clone() as ArrayList<Individual>
    }

    val better: Individual
        get() {
            var idMejor = 0
            for (x in 1 until indivduals.size) {
                if (indivduals[x].fitness > indivduals[idMejor].fitness) {
                    idMejor = x
                }
            }
            return Individual(indivduals[idMejor].genotype)
        }

    fun getMuestraAleatoria(n: Int): ArrayList<Individual> {
        // validar que n <= tamaño de la población
        if (n < indivduals.size) {
            // creamos un coleccion nueva de individuos
            val muestra = ArrayList<Individual>()
            val ran = Random()
            for (x in 0 until n) {
                val pos = ran.nextInt(indivduals.size)
                val e = Individual(indivduals[pos].genotype)
                muestra.add(e)
            }
            return muestra
        }
        return indivduals.clone() as ArrayList<Individual>
    }

    private fun ordenarPoblacionActual() {
        for (z in 1 until indivduals.size) {
            for (v in 0 until indivduals.size - z) {
                if (indivduals[v].fitness
                    > indivduals[v + 1].fitness
                ) {
                    val aux = Individual(indivduals[v].genotype)
                    indivduals[v] = Individual(indivduals[v + 1].genotype)
                    indivduals[v + 1] = aux
                }
            }
        }
    }
}
