package nSat

import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException
import java.util.*
import javax.swing.JFileChooser
import javax.swing.JOptionPane


object Tokenizer {
    var clauses: ArrayList<Clause>? = null
    fun leerDatos() {
        clauses = ArrayList()
        var text: String?
        var aux: String?
        val list = LinkedList<String?>()
        try {
            //llamamos el metodo que permite cargar la ventana
            val file = JFileChooser()
            file.showOpenDialog(file)
            //abrimos el archivo seleccionado
            val openFile = file.selectedFile

            //recorremos el archivo y lo leemos
            if (openFile != null) {
                val files = FileReader(openFile)
                val read = BufferedReader(files)
                while (read.readLine().also { aux = it } != null) {
                    text = aux
                    list.add(text)
                }
                read.close()
                //System.out.println(lista.size());
                val list2 = ArrayList<String>()
                for (i in list.indices) {
                    val st = StringTokenizer(list[i], " ")
                    while (st.hasMoreTokens()) {
                        list2.add(st.nextToken())
                    }
                    val vector = IntArray(list2.size)
                    for (x in list2.indices) {
                        vector[x] = list2[x].toInt()
                    }


                    // a la coleccion de patrones se agrega un nuevo patron
                    clauses!!.add(Clause(vector[0], vector[1], vector[2]))
                    // patrones.add();
                    list2.clear()
                }
            }
        } catch (ex: IOException) {
            JOptionPane.showMessageDialog(
                null, """
     $ex
     No se ha encontrado el archivo
     """.trimIndent(),
                "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE
            )
        }
    }
}
