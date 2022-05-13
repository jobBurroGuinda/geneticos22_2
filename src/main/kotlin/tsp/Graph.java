package tsp;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Graph {

    private JFreeChart graph;
    private XYSeriesCollection series;
    private String tittle;
    private String tittleX;
    private String tittleY;

    public Graph(String titulo,
                 String tituloEjeX,
                 String tituloEjeY) {
        this.tittle = titulo;
        this.tittleX = tituloEjeX;
        this.tittleY = tituloEjeY;
        this.graph = null;
        this.series = new XYSeriesCollection();
    }

    public void createSerie(String nombre){
        XYSeries serie = new XYSeries(nombre);
        this.series.addSeries(serie);

    }

    public void crearPuntoASerie(String nombre, double x, double y){

        this.series.getSeries(nombre).add(x, y);

    }
    public void addSerie(String id, int [] frecuencias){
        XYSeries serie = new XYSeries(id);
        for (int x=0; x<frecuencias.length;x++){
            serie.add(x,frecuencias[x]);
        }

        this.series.addSeries(serie);
    }


    public void createGraph(){
        this.graph = ChartFactory.createScatterPlot(tittle, tittleX, tittleY, series);
        ChartFrame panel = new ChartFrame("Tiempos", graph);
        panel.setVisible(true);
    }

    public void crearGraficaPuntos(){
        this.graph = ChartFactory.createScatterPlot(tittle, tittle, tittle, series);
        ChartFrame panel = new ChartFrame("Tiempos", graph);
        panel.setVisible(true);
    }


}

