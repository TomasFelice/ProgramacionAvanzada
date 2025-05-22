import java.util.ArrayList;
import java.util.List;

public class TDAMonticulo {
    private List<Patient> heap;

    public TDAMonticulo() {
        this.heap = new ArrayList<>();
    }

    /**
     * Agrega un paciente a la cola de prioridad.
     * Complejidad: O(log n)
     */
    public void agregar(Patient paciente) {
        heap.add(paciente);
        int posicionActual = heap.size() - 1;
        int posicionPadre = (posicionActual - 1) / 2;

        // Flotación (heapify-up) - Mueve el nuevo elemento hacia arriba si tiene mayor prioridad que su padre
        while (posicionActual > 0 && heap.get(posicionActual).getTriage().tieneMayorPrioridadQue(heap.get(posicionPadre).getTriage())) {
            intercambiar(posicionActual, posicionPadre);
            posicionActual = posicionPadre;
            posicionPadre = (posicionActual - 1) / 2;
        }
    }

    /**
     * Atiende al paciente con mayor prioridad, eliminándolo de la cola.
     * Complejidad: O(log n)
     */
    public Patient atender() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola de prioridad está vacía");
        }

        Patient pacienteAtendido = heap.getFirst();

        // Reemplazar la raíz con el último elemento
        Patient ultimoElemento = heap.removeLast();

        if (!estaVacia()) {
            heap.set(0, ultimoElemento);
            hundimiento(0);
        }

        return pacienteAtendido;
    }

    /**
     * Procedimiento de hundimiento (heapify-down) para restaurar la propiedad de montículo.
     * Complejidad: O(log n)
     */
    private void hundimiento(int indice) {
        int size = heap.size();
        int indiceMayorPrioridad = indice;
        int hijoIzquierdo = 2 * indice + 1;
        int hijoDerecho = 2 * indice + 2;

        // Comparar con hijo izquierdo
        if (hijoIzquierdo < size &&
            heap.get(hijoIzquierdo).getTriage().tieneMayorPrioridadQue(heap.get(indiceMayorPrioridad).getTriage())) {
            indiceMayorPrioridad = hijoIzquierdo;
        }

        // Comparar con hijo derecho
        if (hijoDerecho < size &&
            heap.get(hijoDerecho).getTriage().tieneMayorPrioridadQue(heap.get(indiceMayorPrioridad).getTriage())) {
            indiceMayorPrioridad = hijoDerecho;
        }

        // Si uno de los hijos tiene mayor prioridad, intercambiar y continuar el hundimiento
        if (indiceMayorPrioridad != indice) {
            intercambiar(indice, indiceMayorPrioridad);
            hundimiento(indiceMayorPrioridad);
        }
    }

    /**
     * Intercambia dos elementos en el montículo.
     */
    private void intercambiar(int i, int j) {
        Patient temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    /**
     * Verifica si la cola de prioridad está vacía.
     * Complejidad: O(1)
     */
    public boolean estaVacia() {
        return heap.isEmpty();
    }

}