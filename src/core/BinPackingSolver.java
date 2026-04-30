package core;

import java.util.List;

/**
 * Interfaz obligatoria para la práctica.
 */
public interface BinPackingSolver {
    /**
     * @param capacity Capacidad máxima de cada contenedor (bin).
     * @param weights Lista de pesos de los objetos a empaquetar.
     * @return Una lista de contenedores, donde cada contenedor es una lista de pesos.
     */
	  List<List<Double>> solve(double capacity, List<Double> weights);

}