package cl.praxis.recliclaJeans;

public class Utilidad {
    public static void limpiarPantalla() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }

    public static void tiempoEspera() {
        try {
            System.out.println("Abandonando el sistema de clientes...");
            Thread.sleep(1000);
            System.out.println("Acaba de salir del sistema");
        } catch (Exception e) {
            System.out.println(e);

        }
    }
}
