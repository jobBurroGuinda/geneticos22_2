package equisCuadrada

import java.util.*

class Individual {

    var genotype: IntArray
        private set

    var phenotype: Int
        private set

    var fitness: Int
        private set

    constructor() {
        genotype = generarGenotipoAleatorio()
        // calculamos el fenotipo
        phenotype = calcularFenotipo()
        fitness = phenotype * phenotype
    }

    constructor(genotipo: IntArray) {
        this.genotype = genotipo.clone()
        phenotype = calcularFenotipo()
        fitness = phenotype * phenotype
    }

    private fun generarGenotipoAleatorio(): IntArray {
        val aux = IntArray(12)
        val ran = Random()
        for (x in aux.indices) aux[x] = ran.nextInt(2)
        return aux
    }

    fun actualizarIndividuo() {
        phenotype = calcularFenotipo()
        fitness = phenotype * phenotype
    }

    private fun calcularFenotipo(): Int {
        // convertir el arreglo de bits a base 10
        var suma = 0
        for (x in genotype.indices) {
            if (genotype[x] == 1) {
                suma += Math.pow(2.0, (genotype.size - 1 - x).toDouble()).toInt()
            }
        }
        return suma
    }
}
