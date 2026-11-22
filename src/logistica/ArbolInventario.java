package logistica;

import java.util.List;

/** ABB manual. La altura se expresa en niveles (árbol vacío = 0). */
public class ArbolInventario {
    private NodoArbol raiz;

    public void insertar(Producto producto) {
        raiz = colocar(raiz, producto);
    }

    private NodoArbol colocar(NodoArbol nodo, Producto producto) {
        if (nodo == null) return new NodoArbol(producto);
        int orden = Integer.compare(producto.getCodigo(), nodo.producto.getCodigo());
        if (orden == 0) throw new IllegalArgumentException("El código ya está registrado.");
        if (orden < 0) nodo.izquierdo = colocar(nodo.izquierdo, producto);
        else nodo.derecho = colocar(nodo.derecho, producto);
        return nodo;
    }

    public Producto buscar(int codigo) {
        NodoArbol actual = raiz;
        while (actual != null) {
            int clave = actual.producto.getCodigo();
            if (codigo == clave) return actual.producto;
            actual = codigo < clave ? actual.izquierdo : actual.derecho;
        }
        return null;
    }

    public void inOrden(List<Producto> salida) {
        java.util.ArrayDeque<NodoArbol> pendientes = new java.util.ArrayDeque<>();
        NodoArbol actual = raiz;
        while (actual != null || !pendientes.isEmpty()) {
            while (actual != null) { pendientes.push(actual); actual = actual.izquierdo; }
            actual = pendientes.pop();
            salida.add(actual.producto);
            actual = actual.derecho;
        }
    }

    public int altura() { return altura(raiz); }

    private int altura(NodoArbol nodo) {
        if (nodo == null) return 0;
        return 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));
    }

    public void descontarStock(int codigo, int cantidad) {
        Producto p = buscar(codigo);
        if (p == null) throw new IllegalArgumentException("Producto inexistente.");
        if (cantidad <= 0) throw new IllegalArgumentException("La cantidad debe ser positiva.");
        if (cantidad > p.getStock()) throw new IllegalStateException("Stock insuficiente. Disponibles: " + p.getStock() + " unidades.");
        p.setStock(p.getStock() - cantidad);
    }
}
