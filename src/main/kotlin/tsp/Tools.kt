package tsp

import java.io.BufferedReader
import java.io.FileNotFoundException
import java.io.FileReader
import java.io.IOException
import java.util.*
import java.util.logging.Level
import java.util.logging.Logger
import javax.swing.JFileChooser


object Tools {
    lateinit var distances: Array<DoubleArray>
    lateinit var inclinations: DoubleArray
    fun generarDistanciasAletorias(numCiudades: Int, limDistancia: Int) {
        distances = Array(numCiudades) { DoubleArray(numCiudades) }
        val ran = Random()
        for (x in 0 until numCiudades) for (y in x until numCiudades) {
            val dist = ran.nextInt(limDistancia) + 0.1
            if (x == y) {
                distances[x][y] = 0.0
            } else {
                distances[x][y] = dist
                distances[y][x] = dist
            }
        }
    }

    fun generateRandomInclinations(numCiudades: Int, limInclinacion: Int) {
        inclinations = DoubleArray(numCiudades)
        val ran = Random()
        for (y in 0 until numCiudades) {
            val incli = ran.nextInt(limInclinacion) + 0.1
            inclinations[y] = incli
        }
    }

    fun uploadDistances() {
        var files: FileReader? = null
        try {
            var string: String
            val file = JFileChooser()
            file.showOpenDialog(file)
            //abrimos el archivo seleccionado
            val openFile = file.selectedFile
            files = FileReader(openFile)
            val read = BufferedReader(files)
            val array = mutableListOf<MutableList<Double>?>()
            if (openFile != null) {
                var i = 0
                while (read.readLine().also { string = it } != null) {
                    val data = string.split(",".toRegex()).toTypedArray()
                    val c = mutableListOf<Double>()
                    for (j in data.indices) {
                        c.add(data[j].toDouble())
                    }
                    array.add(c)
                    i++
                }
                read.close()
            }
            distances = Array(array.size) { DoubleArray(array.size) }
            for (i in array.indices) {
                for (j in array[0]!!.indices) {
                    distances[i][j] = array[i]!![j]
                }
            }
        } catch (ex: FileNotFoundException) {
            Logger.getLogger(Tools::class.java.name).log(Level.SEVERE, null, ex)
        } catch (ex: IOException) {
            Logger.getLogger(Tools::class.java.name).log(Level.SEVERE, null, ex)
        } finally {
            try {
                files!!.close()
            } catch (ex: IOException) {
                Logger.getLogger(Tools::class.java.name).log(Level.SEVERE, null, ex)
            }
        }
    }

    fun guardarDistancias() {}
}
