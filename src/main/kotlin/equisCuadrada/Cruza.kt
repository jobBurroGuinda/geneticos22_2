package equisCuadrada

object Cruza {
    fun cruzaXMascara(mask: IntArray, mother: Individual, father: Individual): Individual {
        val child1: Individual
        val child2: Individual
        val gen1 = IntArray(12)
        val gen2 = IntArray(12)
        // recorrer la maskara de cruza
        for (x in mask.indices) {
            // 1 madre y 0 padre
            if (mask[x] == 1) {
                gen1[x] = mother.genotype[x]
                gen2[x] = father.genotype[x]
            } else {
                gen1[x] = father.genotype[x]
                gen2[x] = mother.genotype[x]
            }
        }
        child1 = Individual(gen1)
        child2 = Individual(gen2)
        return if (child1.fitness > child2.fitness) {
            child1
        } else {
            child2
        }
    }
}
