package equisCuadrada

import equisCuadrada.Muta.mutaBit
import equisCuadrada.Seleccion.seleccionAleatoria
import java.util.*


class GeneticX2(private val noGenerations: Int, private val sizePopulation: Int, private val pMutate: Double) {
    // parametros
    private var poblacionActual: Poblacion
    fun evolucionar() {
        // generar las itereaciones para las generaciones
        for (g in 1 until noGenerations) {
            // garantizar construir una nueva población
            val ind = ArrayList<Individual?>()
            for (i in 0 until sizePopulation) {
                // seleccionamos
                val mother = seleccionAleatoria(poblacionActual)
                val father = seleccionAleatoria(poblacionActual)
                // reproducimos
                val child: Individual = Cruza.cruzaXMascara(intArrayOf(1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0), mother, father)
                // mutamos
                // evaluar la probabilidad
                mutaBit(pMutate, child)
                // agregamos
                ind.add(child)
            }
            // actualizamos la nueva población
            poblacionActual = Poblacion(ind)
            println(g)
        }
        // pedimos el mejor a la poblacion
        val mejor = poblacionActual.better
        println(mejor.phenotype)
        println(mejor.fitness)
        println(Arrays.toString(mejor.genotype))
    }

    init {
        poblacionActual = Poblacion(sizePopulation)
    }
}
