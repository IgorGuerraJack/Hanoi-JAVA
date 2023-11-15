package com.mycompany.principal;

public class Principal {

    public static void main(String[] args) {
        int discos = 7;  

        System.out.println("Instância Final (" + discos + " discos):");

        long startTime = System.currentTimeMillis();
        long movimentos = hanoi(discos, 'A', 'B', 'C');
        long endTime = System.currentTimeMillis();

        String formattedTime = formatTime(endTime - startTime);

        System.out.println("Tempo de execução: " + formattedTime);
        System.out.println("Movimentos realizados: " + movimentos);
    }

    private static long hanoi(long n, char origem, char auxiliar, char destino) {
        long movimentos = 0;
        if (n > 0) {
            movimentos += hanoi(n - 1, origem, destino, auxiliar);
            movimentos += hanoi(n - 1, auxiliar, origem, destino) + 1;
        }
        return movimentos;
    }

    private static String formatTime(long elapsedTime) {
        long ms = elapsedTime % 1000, s = (elapsedTime / 1000) % 60, m = (elapsedTime / (1000 * 60)) % 60, h = (elapsedTime / (1000 * 60 * 60)) % 24;
        return String.format("%02d:%02d:%02d:%d", h, m, s, ms);
    }
}