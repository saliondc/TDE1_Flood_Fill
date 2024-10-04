public class Pilha {
    private Pixel[] elementos;
    private int topo;

    public Pilha(int capacidade) {
        elementos = new Pixel[capacidade];
        topo = -1;
    }

    public void push(Pixel p) {
        if (topo < elementos.length - 1) {
            elementos[++topo] = p;
        }
    }

    public Pixel pop() {
        if (topo >= 0) {
            return elementos[topo--];
        }
        return null;
    }

    public boolean isEmpty() {
        return topo == -1;
    }
}
