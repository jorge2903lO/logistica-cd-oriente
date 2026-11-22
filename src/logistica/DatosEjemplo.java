package logistica;

/** Datos ficticios del centro para reproducir la demostración. */
final class DatosEjemplo {
    private DatosEjemplo() {}
    static void cargar(ArbolInventario inventario, ColaCamiones cola, GrafoRutas red) {
        inventario.insertar(new Producto(850, "Café tostado", 100));
        inventario.insertar(new Producto(730, "Cacao en grano", 130));
        inventario.insertar(new Producto(960, "Aceite de sacha inchi", 42));
        inventario.insertar(new Producto(685, "Harina de plátano", 95));
        inventario.insertar(new Producto(920, "Palmito en conserva", 64));
        cola.encolar(new Camion("SMO-201", "Nora Paz", 6));
        cola.encolar(new Camion("SMO-217", "Joel Díaz", 10));
        cola.encolar(new Camion("SMO-239", "Alba Cruz", 7.5));
        red.agregarCiudad("Tarapoto");
        red.agregarCiudad("Lamas");
        red.agregarCiudad("Juanjuí");
        red.agregarCiudad("Moyobamba");
        red.agregarCiudad("Bellavista");
        red.agregarRuta("Tarapoto", "Lamas", 24);
        red.agregarRuta("Tarapoto", "Juanjuí", 136);
        red.agregarRuta("Lamas", "Moyobamba", 94);
        red.agregarRuta("Juanjuí", "Bellavista", 37);
    }
}
