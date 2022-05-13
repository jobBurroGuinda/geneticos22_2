package tsp

import tsp.Cruza.cruzaAsexual
import tsp.Tools.uploadDistances
import tsp.Mutate.mutaGen
import tsp.Selection.randomSelection
import tsp.Selection.tournamentSelection


class GeneticTSP(private val noGenerations: Int, private val sizePopulation: Int, noCities: Int, ci: Int, private val pMutate: Double) {
    // parametros
    private var poblacionActual: Population
    fun evolve() {
        val grafical = Graph("Puntos ", "Distancias", "Inclinaciones")
        grafical.createSerie("0")
        var better: Individual? = null
        // generar las itereaciones para las generaciones
        for (g in 1 until noGenerations) {
            // garantizar construir una nueva población
            val ind = ArrayList<Individual?>()
            for (i in 0 until sizePopulation) {
                // seleccionamos
                val mother = tournamentSelection(poblacionActual)
                val father = randomSelection(poblacionActual)

                // reproducimos
                val child = cruzaAsexual(mother, father)
                // mutamos
                // evaluar la probabilidad
                mutaGen(pMutate, child)
                // agregamos
                ind.add(child)
            }
            // actualizamos la nueva población
            poblacionActual = Population(ind)
            // pedimos el mejor a la poblacion
            better = poblacionActual.better
            grafical.crearPuntoASerie("0", better.fitnessDistance, better.fitnessInclination)
            println(g.toString() + ": " + better.fitnessGeneral)
        }
        grafical.createGraph()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            uploadDistances()
            val g = GeneticTSP(100000, 100, Tools.distances.size, 0, 0.001)
            g.evolve()
        }
    }

    init {
        poblacionActual = Population(sizePopulation, noCities, ci)
        //mejor();
    }
}
