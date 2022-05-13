package nSat

import java.util.*


class Population {
    var individuals: ArrayList<Individual>
        private set

    constructor(numInd: Int) {
        individuals = ArrayList()
        for (x in 0 until numInd) individuals.add(Individual())
    }

    constructor(aux: ArrayList<Individual?>) {
        individuals = aux.clone() as ArrayList<Individual>
    }

    fun getNBetters(n: Int): ArrayList<Individual> {
        // validar que n <= tamaño de la población
        if (n < individuals.size) {
            // ordenar a la población
            ordenarPoblacionActual()
            // creamos un coleccion nueva de individuos
            val muestra = ArrayList<Individual>()
            for (x in individuals.size - 1 downTo individuals.size - n) {
                val e = Individual(individuals[x].genotype)
                muestra.add(e)
            }
            return muestra
        }
        return individuals.clone() as ArrayList<Individual>
    }

    val better: Individual
        get() {
            var idBetter = 0
            for (x in 1 until individuals.size) {
                if (individuals[x].fitness > individuals[idBetter].fitness) {
                    idBetter = x
                }
            }
            return Individual(individuals[idBetter].genotype)
        }

    fun getMuestraAleatoria(n: Int): ArrayList<Individual> {
        // validar que n <= tamaño de la población
        if (n < individuals.size) {
            // creamos un coleccion nueva de individuos
            val muestra = ArrayList<Individual>()
            val ran = Random()
            for (x in 0 until n) {
                val pos = ran.nextInt(individuals.size)
                val e = Individual(individuals[pos].genotype)
                muestra.add(e)
            }
            return muestra
        }
        return individuals.clone() as ArrayList<Individual>
    }

    private fun ordenarPoblacionActual() {
        for (z in 1 until individuals.size) {
            for (v in 0 until individuals.size - z) {
                if (individuals[v].fitness
                    > individuals[v + 1].fitness
                ) {
                    val aux = Individual(individuals[v].genotype)
                    individuals[v] = Individual(individuals[v + 1].genotype)
                    individuals[v + 1] = aux
                }
            }
        }
    }
}
