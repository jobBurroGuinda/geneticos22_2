package nReynas


class Manager(id: String, private val reinas: Int) {
    private val id: String
    private var nG = 0
    private var ejecucion = false
    private val geneticos: ArrayList<GeneticoNReinas>
    private val configuraciones: ArrayList<Configuration?>
    fun generarGeneticos(configuraciones: ArrayList<Configuration?>) {
        // crear los geneticos en base a las configuraciones
        nG = configuraciones.size
        for (x in 0 until nG) {
            this.configuraciones.add(configuraciones[x])
            val gen = configuraciones[x]?.let { GeneticoNReinas(it) }
            if (gen != null) {
                geneticos.add(gen)
            }
        }
    }

    fun generarGeneticos(nG: Int) {
        // crear los geneticos en base a las configuraciones
        for (x in 0 until nG) {
            configuraciones.add(Configuration(reinas))
            val gen = configuraciones[x]?.let { GeneticoNReinas(it) }
            if (gen != null) {
                geneticos.add(gen)
            }
        }
    }

    fun ejecutarGeneticos() {
        // ejecutar los geneticos en un hilo diferente
        for (aux in geneticos) {
            val hilo = Thread(aux)
            hilo.start()
        }
        ejecucion = true
    }

    init {
        geneticos = ArrayList()
        configuraciones = ArrayList()
        this.id = id
    }
}
