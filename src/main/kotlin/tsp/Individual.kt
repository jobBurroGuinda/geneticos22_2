package tsp

import java.util.*


class Individual {
    var genotype = intArrayOf()
        private set

    var fitnessDistance = 0.0
        private set

    var fitnessInclination = 0.0
        private set

    var fitnessGeneral = 0.0
        private set
    private var n: Int
    private var ci: Int

    constructor(n: Int, ci: Int) {
        this.n = n
        this.ci = ci
        generateRandomGenotype()
        calculateFitnessDistance()
        calculateGeneralFitness()
    }

    constructor(genotype: IntArray) {
        n = genotype.size
        ci = genotype[0]
        this.genotype = genotype.clone()
        calculateFitnessDistance()
        calculateFitnessInclination()
        calculateGeneralFitness()
    }

    private fun generateRandomGenotype() {
        genotype = IntArray(n)
        val list = ArrayList<Int>()
        val ran = Random()
        // inicializar
        for (x in genotype.indices) {
            if (x != ci) list.add(x)
        }
        genotype[0] = ci
        for (x in 1 until genotype.size) {
            val i = ran.nextInt(list.size)
            genotype[x] = list.removeAt(i)
        }
    }

    fun updateIndividual() {
        calculateFitnessDistance()
        calculateFitnessInclination()
        calculateGeneralFitness()
    }

    private fun calculateFitnessInclination() {
        // recorrer el individudo y consultamos las inclinaciones
        for (x in 0 until genotype.size - 1) {
            fitnessInclination += Tools.inclinations.get(genotype[x]) - Tools.inclinations.get(
                genotype[x + 1]
            )
        }
        // agregamos la inclinacion de la ultima a la inicial
        fitnessInclination += Tools.inclinations.get(genotype[genotype.size - 1]) - Tools.inclinations.get(
            genotype[0]
        )
    }

    private fun calculateFitnessDistance() {
        val ultima = genotype[n - 1]
        val primera = genotype[0]
        fitnessDistance = Tools.distances.get(primera).get(ultima)
        // recorremos el genotipo
        for (x in 0 until n - 1) {
            fitnessDistance += Tools.distances.get(genotype[x]).get(genotype[x + 1])
        }
    }

    private fun calculateGeneralFitness() {
        // 1er Forma
        fitnessGeneral = 0.5 * Math.abs(fitnessDistance) + 0.5 * Math.abs(fitnessInclination)
    }
}
