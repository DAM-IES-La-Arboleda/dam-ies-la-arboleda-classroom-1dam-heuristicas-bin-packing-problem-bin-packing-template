package core;

import solution.BaseSolver; 
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Uso: java core.Main <directorio_de_pruebas>");
            return;
        }

        File folder = new File(args[0]);
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));
        
        if (files == null || files.length == 0) {
            System.out.println("No se encontraron archivos .txt");
            return;
        }

        Arrays.sort(files);
        BinPackingSolver solver = new BaseSolver(); 
        
        double totalScore = 0;
        int count = 0;

        System.out.println("\n=== EVALUACIÓN DE HEURÍSTICA ===");
        System.out.printf("%-15s | %-6s | %-6s | %-8s | %-6s%n", "ARCHIVO", "BINS", "IDEAL", "TIEMPO", "SCORE");
        System.out.println("------------------------------------------------------------");

        for (File f : files) {
            double score = evaluateFile(f, solver);
            if (score >= 0) {
                totalScore += score;
                count++;
            }
        }

        if (count > 0) {
            System.out.println("------------------------------------------------------------");
            System.out.printf("PUNTUACIÓN MEDIA FINAL: %.2f / 100.00%n", (totalScore / count));
            System.out.println("============================================================\n");
            System.out.println("FINAL_SCORE=" + (totalScore / count));
        }
    }

    private static double evaluateFile(File f, BinPackingSolver solver) {
        try (Scanner sc = new Scanner(f).useLocale(Locale.US)) {
            double capacity = sc.nextDouble();
            List<Double> weights = new ArrayList<>();
            double sumWeights = 0;
            while (sc.hasNextDouble()) {
                double w = sc.nextDouble();
                weights.add(w);
                sumWeights += w;
            }

            // Cálculo de la Cota Inferior (Lower Bound)
            int lowerBound = (int) Math.ceil(sumWeights / capacity);

            long start = System.nanoTime();
            List<List<Double>> result = solver.solve(capacity, new ArrayList<>(weights));
            long end = System.nanoTime();

            if (BinValidator.isValid(capacity, weights, result)) {
                int binsUsed = result.size();
                double score = ((double) lowerBound / binsUsed) * 100;
                double ms = (end - start) / 1_000_000.0;

                System.out.printf("%-15s | %-6d | %-6d | %-6.2fms | %-6.2f%n", 
                                  f.getName(), binsUsed, lowerBound, ms, score);
                return score;
            } else {
                System.out.printf("%-15s | INVALID SOLUTION%n", f.getName());
                return 0;
            }
        } catch (Exception e) {
            return -1;
        }
    }
}