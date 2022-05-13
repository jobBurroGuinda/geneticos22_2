package nReynas

import nReynas.Cruza.cruzaXMascara
import java.util.*


class GeneticoNReinas(
    val manager: Configuration
) : Runnable {
    // parametros
    private var poblacionActual: Population

    fun evolve() {

        // generar las itereaciones para las generaciones
        for (g in 1 until manager.numGenerations) {
            // garantizar construir una nueva población
            var ind: ArrayList<Individual?>
            // calcular un N
            val n = (manager.sizePopulation * manager.pMuestra) as Int
            if (n > 0) {
                ind = ArrayList()
                ind.add(poblacionActual.better)
            } else {
                ind = ArrayList()
            }
            for (i in n until manager.sizePopulation) {
                // seleccionamos
                val mother = manager.aplicarSeleccion(poblacionActual, 0)
                val father = manager.aplicarSeleccion(poblacionActual, 1)
                // reproducimos
                val child = cruzaXMascara(manager.mask, mother!!, father!!)
                // mutamos
                // evaluar la probabilidad
                Mutate.mutaGen(manager.probMutate, child)
                // agregamos
                ind.add(child)
            }
            // actualizamos la nueva población
            poblacionActual = Population(ind)
            //System.out.println(g);
            // pedimos el mejor a la poblacion
            val better = poblacionActual.better
            val f = better.fitness
            println("g" + g + " f:" + f + " id:" + this.hashCode())
            if (f == 0) {
                println("Better: g" + g + " " + Arrays.toString(better.genotype))
                break
            }
        }
        // pedimos el mejor a la poblacion
//    Individual mejor  = this.poblacionActual.getMejor();
//    System.out.println(mejor.getFitness());
        //System.out.println(Arrays.toString(mejor.getGenotipo()));
    }

    override fun run() {
        evolve()
    }

    init {
        poblacionActual = Population(manager.sizePopulation, manager.sizeGenotype)
    }
}
