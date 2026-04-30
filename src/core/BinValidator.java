package core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinValidator {

    // Margen de tolerancia para errores de precisión de punto flotante
    private static final double EPSILON = 1e-9;

    public static boolean isValid(double capacity, List<Double> originalWeights, List<List<Double>> solution) {
        List<Double> flatSolution = new ArrayList<>();
        
        for (List<Double> bin : solution) {
            double currentBinSum = 0;
            for (Double weight : bin) {
                currentBinSum += weight;
                flatSolution.add(weight);
            }
            
            // Regla 1: No exceder la capacidad (con margen de error)
            if (currentBinSum > capacity + EPSILON) {
                System.err.println("Error: Un contenedor excede la capacidad (" + currentBinSum + " > " + capacity + ")");
                return false;
            }
        }

        // Regla 2: ¿Están todos los objetos? 
        // Nota: Comparar doubles directamente puede ser peligroso, pero aquí 
        // comparamos los valores originales que fueron leídos del fichero.
        if (originalWeights.size() != flatSolution.size()) {
            System.err.println("Error: Cantidad de objetos incorrecta.");
            return false;
        }

        List<Double> sortedOriginal = new ArrayList<>(originalWeights);
        List<Double> sortedSolution = new ArrayList<>(flatSolution);
        Collections.sort(sortedOriginal);
        Collections.sort(sortedSolution);

        for (int i = 0; i < sortedOriginal.size(); i++) {
            if (Math.abs(sortedOriginal.get(i) - sortedSolution.get(i)) > EPSILON) {
                System.err.println("Error: Los pesos de la solución no coinciden con los originales.");
                return false;
            }
        }

        return true;
    }
}