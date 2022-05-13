package nReynas

import java.util.*


object Cruza {
    fun generarMascaraAleatoria(dim: Int): IntArray {
        val mask = IntArray(dim)
        val ran = Random()
        for (x in 0 until dim) {
            mask[x] = ran.nextInt(2)
        }
        return mask
    }

    fun cruzaXMascara(mask: IntArray, madre: Individual, padre: Individual): Individual {
        val child1: Individual
        val child2: Individual
        val gen1 = IntArray(madre.genotype.size)
        val gen2 = IntArray(padre.genotype.size)
        // recorrer la maskara de cruza
        for (x in mask.indices) {
            // 1 madre y 0 padre
            if (mask[x] == 1) {
                gen1[x] = madre.genotype[x]
                gen2[x] = padre.genotype[x]
            } else {
                gen1[x] = padre.genotype[x]
                gen2[x] = madre.genotype[x]
            }
        }
        child1 = Individual(gen1)
        child2 = Individual(gen2)
        return if (child1.fitness < child2.fitness) {
            child1
        } else {
            child2
        }
    }
}
