package solution;

import core.BinPackingSolver;
import java.util.*;

public class BaseSolver implements BinPackingSolver {
    @Override
    public List<List<Double>> solve(double capacity, List<Double> weights) {
        List<List<Double>> bins = new ArrayList<>();

        for (double weight: weights) {
        	bins.add(List.of(weight));
        }
        return bins;
    }
}