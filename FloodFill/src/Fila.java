public class Fila {
    private Pixel[] elementos;
    private int inicio, fim, tamanho;

    public Fila(int capacidade) {
        elementos = new Pixel[capacidade];
        inicio = 0;
        fim = 0;
        tamanho = 0;
    }

    public void enqueue(Pixel p) {
        if (tamanho < elementos.length) {
            elementos[fim] = p;
            fim = (fim + 1) % elementos.length;
            tamanho++;
        }
    }

    public Pixel dequeue() {
        if (tamanho > 0) {
            Pixel p = elementos[inicio];
            inicio = (inicio + 1) % elementos.length;
            tamanho--;
            return p;
        }
        return null;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }
}
