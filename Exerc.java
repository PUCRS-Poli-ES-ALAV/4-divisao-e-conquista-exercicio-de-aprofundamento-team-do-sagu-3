import java.util.List;

public class Exerc {

    public int[] quebraVet(int[] vetor) {
        /*
         * MERGE-SORT(L: List with n elements) : Ordered list with n elements
         * IF (list L has one element)
         * RETURN L.
         * Divide the list into two halves A and B.
         * A ← MERGE-SORT(A).
         * B ← MERGE-SORT(B).
         * L ← MERGE(A, B).
         * RETURN L.
         * ```
         */
        if (vetor.length == 1) {
            return vetor;
        }
        int meio = vetor.length / 2;
        int[] esquerda = new int[meio];
        int[] direita = new int[vetor.length - meio];

        for (int i = 0; i < meio; i++) {
            esquerda[i] = vetor[i];
        }

        for (int i = meio; i < vetor.length; i++) {
            direita[i - meio] = vetor[i];
        }

        esquerda = quebraVet(esquerda);
        direita = quebraVet(direita);
        return merge(esquerda, direita);
    }

    public int[] merge(int[] esquerda, int[] direita) {
        int[] result = new int[esquerda.length + direita.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < esquerda.length && j < direita.length) {
            if (esquerda[i] <= direita[j]) {
                result[k] = esquerda[i];
                k++;
                i++;
            } else {
                result[k] = direita[j];
                k++;
                j++;
            }
        }

        while (i < esquerda.length) {
            result[k++] = esquerda[i++];
        }

        while (j < direita.length) {
            result[k++] = direita[j++];
        }

        return result;
    }

}
