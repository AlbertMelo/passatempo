package passatempo.DesignDeEscritorio;

import java.util.Scanner;

class MaxCollors {

    public static void main(final String[] args) {

        final Scanner entrada = new Scanner(System.in);
        int precosSize = 0, io;
        int[] prices;
        int money;

        // entrada do tamanho
        precosSize = entrada.nextInt();
        prices = new int[precosSize];

        // entrada dos precos
        for (io = 0; io < precosSize; io++) {

            prices[io] = entrada.nextInt();
        }
        // entrada do dinheiro

        money = entrada.nextInt();
        entrada.close();

        System.out.println(getMaxColors(prices, money));
    }

    /*
     * Funcao que retorna o valor máximo de cores que a empresa pode comprar em um
     * paleta com o dinheiro disponivel
     */
    public static int getMaxColors(final int prices[], final int money) {

        int sizePrices = prices.length;
        int maxCollors = 0;

        for (int sequencia = 1; sequencia <= sizePrices; sequencia++)

            if (existeSequencia(prices, sequencia, money)) {
                maxCollors = sequencia;
            }

        return maxCollors;
    }

    private static boolean existeSequencia(int[] prices, int sequencia, int money) {

        boolean resposta = false;
        int sum, psum, p;

        for (p = 0; p + sequencia - 1 < prices.length; p++) {
            sum = 0;
            for (psum = p; psum  <= p + sequencia-1; psum++) {
                sum = sum + prices[psum];
            }
            if (sum <= money) {
                resposta = true;
                break;
            }

        }

        return resposta;
    }

}