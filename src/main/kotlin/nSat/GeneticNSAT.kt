package nSat

import nSat.Cruza.cruzaXMascara
import nSat.Cruza.generateRandomMask
import nSat.Selection.randomSelection
import nSat.Selection.tournamentSelection
import java.util.*


class GeneticNSAT(val numG: Int, private val tamP: Int, private val pMuta: Double) {
    // parametros
     var poblacionActual: Population
    fun evolve() {
        val mask = generateRandomMask(100)
        var better: Individual? = null
        // generar las itereaciones para las generaciones
        for (g in 1 until numG) {
            // garantizar construir una nueva población
            val ind = ArrayList<Individual?>()
            for (i in 0 until tamP) {
                // seleccionamos
                val mother = tournamentSelection(poblacionActual)
                val father = randomSelection(poblacionActual)

                // reproducimos
                val child = cruzaXMascara(mask, mother, father)
                // mutamos
                // evaluar la probabilidad
                Mutate.mutaBit(pMuta, child)
                // agregamos
                ind.add(child)
            }
            // actualizamos la nueva población
            poblacionActual = Population(ind)
            // pedimos el mejor a la poblacion
            better = poblacionActual.better
            println(g.toString() + ": " + better.fitness)
        }
        println(better!!.fitness)
        println(Arrays.toString(better.genotype))
    }

    private fun better() {
        val i = Individual(
            intArrayOf(
                0,
                0,
                0,
                1,
                0,
                1,
                1,
                0,
                1,
                0,
                0,
                0,
                1,
                1,
                1,
                0,
                1,
                1,
                0,
                1,
                1,
                1,
                0,
                0,
                0,
                0,
                0,
                1,
                1,
                0,
                1,
                1,
                1,
                0,
                1,
                1,
                1,
                0,
                0,
                1,
                0,
                0,
                1,
                1,
                0,
                1,
                1,
                0,
                1,
                1,
                1,
                1,
                0,
                1,
                0,
                1,
                0,
                1,
                1,
                0,
                1,
                0,
                0,
                1,
                0,
                1,
                1,
                0,
                0,
                1,
                0,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                1,
                0,
                0,
                1,
                0,
                0,
                0,
                1,
                0,
                1,
                0,
                1,
                1,
                1,
                0
            )
        )
        poblacionActual.individuals.add(i)
    }

    init {
        poblacionActual = Population(tamP)
        //mejor();
    }
}
