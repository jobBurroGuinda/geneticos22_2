package nReynas

import nReynas.Cruza.generarMascaraAleatoria
import nReynas.Selection.SelectionType
import nReynas.Selection.randomSelection
import nReynas.Selection.tounamentSelection

class Configuration {
    var numGenerations: Int
    var sizePopulation: Int
    var probMutate: Double
     var pMuestra: Double
    var mask: IntArray
    var typeSelection: Array<SelectionType>
    var sizeGenotype: Int

    constructor(
        numGeneraciones: Int,
        tamPoblacion: Int,
        probMuta: Double,
        pMuestra: Double,
        selectionType: Array<SelectionType>,
        tamGenotipo: Int
    ) {
        this.numGenerations = numGeneraciones
        this.sizePopulation = tamPoblacion
        this.probMutate = probMuta
        this.pMuestra = pMuestra
        mask = generarMascaraAleatoria(tamGenotipo)
        this.typeSelection = selectionType
        this.sizeGenotype = tamGenotipo
    }

    constructor(tamGenotipo: Int) {
        numGenerations = 10000
        sizePopulation = 50
        probMutate = 0.2
        pMuestra = 0.2
        mask = generarMascaraAleatoria(tamGenotipo)
        typeSelection = arrayOf(SelectionType.TOURNAMENT, SelectionType.RANDOM)
        this.sizeGenotype = tamGenotipo
    }

    fun aplicarSeleccion(pobActual: Population?, i: Int): Individual? {
        var aux: Individual? = null
        aux = when (typeSelection[i]) {
            SelectionType.RANDOM -> {
                randomSelection(pobActual!!)
            }
            SelectionType.TOURNAMENT -> {
                tounamentSelection(pobActual!!)
            }
            else -> null
        }
        return aux
    }

}
