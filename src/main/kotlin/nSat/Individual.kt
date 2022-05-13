package nSat

import java.util.*


class Individual {
    var genotype = intArrayOf()
        private set

    var fitness = 0
        private set

    constructor() {
        generateRandomGenotype()
        calculateFitness()
    }

    constructor(genotipo: IntArray) {
        this.genotype = genotipo.clone()
        calculateFitness()
    }

    private fun generateRandomGenotype() {
        genotype = IntArray(100)
        val ran = Random()
        for (x in genotype.indices) genotype[x] = ran.nextInt(2)
    }

    fun updateIndividual() {
        calculateFitness()
    }

    private fun calculateFitness() {
        // recorrer las clausulas
        fitness = 0
        for (c in Tokenizer.clauses!!) {
            if (verifyClause(c)) {
                fitness++
            }
        }
    }

    private fun verifyClause(c: Clause): Boolean {
        return verifyNeg(c.a) == 1 || verifyNeg(c.b) == 1 || verifyNeg(c.c) == 1
    }

    private fun verifyNeg(a: Int): Int {
        var a = a
        var negacion = false
        var value = -1
        if (a < 0) {
            a *= -1
            negacion = true
        }
        if (negacion) {
            value = genotype[a - 1]
            value = if (value == 0) {
                1
            } else {
                0
            }
        } else {
            value = genotype[a - 1]
        }
        return value
    }
}

