package tsp

import java.util.*


object Cruza {
    fun cruza(mother: Individual, father: Individual): Individual {
        val i1 = Individual(mother.genotype)
        val i2 = Individual(father.genotype)
        Mutate.mutaGen(1.0, i1)
        Mutate.mutaGen(1.0, i2)
        return if (i1.fitnessDistance < i2.fitnessDistance) i1 else i2
    }

    fun cruzaAsexual(father: Individual, mother: Individual): Individual {
        val maskIndices = IntArray(father.genotype.size - 1)
        // creo la mascara de índices
        for (ii in maskIndices.indices) {
            maskIndices[ii] = -1
        }
        for (i in 1..maskIndices.size) {
            val ind = generarIndiceValido(maskIndices)
            maskIndices[ind] = i
        }
        val geno1 = IntArray(father.genotype.size)
        val geno2 = IntArray(mother.genotype.size)
        geno1[0] = father.genotype[0]
        geno2[0] = mother.genotype[0]
        // construimos los nuevos genotipos
        for (x in 1 until geno1.size) {
            geno1[maskIndices[x - 1]] = father.genotype[x]
            geno2[maskIndices[x - 1]] = mother.genotype[x]
        }
        val child1 = Individual(geno1)
        val child2 = Individual(geno2)
        val list = ArrayList<Individual>()
        list.add(mother)
        list.add(father)
        list.add(child1)
        list.add(child2)
        return returnBetter(list)
    }

    private fun returnBetter(list: ArrayList<Individual>): Individual {
        var better = list[0]
        for (x in 1 until list.size) {
            if (list[x].fitnessDistance < better.fitnessDistance) {
                better = list[x]
            }
        }
        return better
    }

    fun generarIndiceValido(ruta: IntArray): Int {
        val r = Random()
        var indice = r.nextInt(ruta.size)
        while (ruta[indice] != -1) {
            indice = r.nextInt(ruta.size)
        }
        return indice
    }
}
