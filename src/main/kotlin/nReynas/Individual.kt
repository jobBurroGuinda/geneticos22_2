package nReynas

import java.util.*


class Individual {
    var genotype: IntArray
        private set

    var fitness = 0
        private set
    private var n: Int

    constructor(n: Int) {
        this.n = n
        genotype = generarGenotipoAleatorio()
        calculateFitness()
    }

    constructor(genotipo: IntArray) {
        n = genotipo.size
        this.genotype = genotipo.clone()
        calculateFitness()
    }

    private fun generarGenotipoAleatorio(): IntArray {
        val aux = IntArray(n)
        val ran = Random()
        for (x in aux.indices) aux[x] = ran.nextInt(n)
        return aux
    }

    fun updateIndividual() {
        calculateFitness()
    }

    private fun calculateFitness() {
        fitness = 0
        // recorremos el genotipo
        for (x in 0 until n - 1) {
            for (y in x + 1 until n) {
                // evaluamos los ataques
                val a = genotype[x]
                val b = genotype[y]
                val auxx = genotype[x] - x
                val auxy = genotype[y] - y
                val aux2x = genotype[x] + x
                val aux2y = genotype[y] + y
                if (a == b || auxx == auxy || aux2x == aux2y) {
                    fitness += 2
                }
            }
        }
    }
}
