package Banking;

import java.util.Scanner;

/**
 * Esta clase es la encargada de generar y gestionar la Interfaz Gráfica.
 */

public class UserInterface {

	/**
	 * Crear una instancia de la clase Management.
	 */
    private static Management manager = new Management();

    /**
     * El inicio de un programa en Java
     * @param args	Array de tipo String
     */
    public static void main(String[] args) {

        iniciarUI();
    }

    /**
     * Método encargado de imprimir la interfaz por pantalla.
     */
    public static void iniciarUI() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBienvenido al banco");
            System.out.println("1. Crear nueva cuenta");
            System.out.println("2. Ingresar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Transferir dinero");
            System.out.println("5. Mostrar detalles de la cuenta");
            System.out.println("6. Terminar");
            System.out.print("Seleccione una opción: ");

            int eleccion = scanner.nextInt();
            scanner.nextLine();

            switch (eleccion) {
                case 1:
                    uiCrearCuenta(scanner);
                    break;
                case 2:
                    uiDepositar(scanner);
                    break;
                case 3:
                    uiRetirar(scanner);
                    break;
                case 4:
                    uiTransferencia(scanner);
                    break;
                case 5:
                    manager.mostrarCuentas();
                    break;
                case 6:
                    System.out.println("Gracias por usar la aplicación.");
                    return;
                default:
                    System.out.println("Opción inválida, por favor, inténtelo de nuevo.");
            }
        }
    }

    /**
     * Método encargado de recoger los datos necesarios para crear una nueva cuenta.
     * @param scanner	Scanner es una utilidad la cual recoge lo que escriba el usuario
     */
    private static void uiCrearCuenta(Scanner scanner) {
        System.out.print("Introduzca el identificador de cuenta: ");
        String idCuenta = scanner.nextLine();
        System.out.print("Introduzca el nombre del dueño: ");
        String propietarioCuenta = scanner.nextLine();
        manager.crearCuenta(idCuenta, propietarioCuenta);
    }

    /**
     * Método encargado de recoger los datos necesarios para depositar dinero.
     * @param scanner	Scanner es una utilidad la cual recoge lo que escriba el usuario
     */
    private static void uiDepositar(Scanner scanner) {
        System.out.print("Introduzca el identificador de cuenta: ");
        String idCuenta = scanner.nextLine();
        System.out.print("Introduzca la cantidad a ingresar: ");
        double cantidad = scanner.nextDouble();
        scanner.nextLine();
        manager.depositarACuenta(idCuenta, cantidad);
    }

    /**
     * Método encargado de recoger los datos necesarios para retirar dinero.
     * @param scanner	Scanner es una utilidad la cual recoge lo que escriba el usuario
     */
    private static void uiRetirar(Scanner scanner) {
        System.out.print("Introduzca el identificador de cuenta: ");
        String idCuenta = scanner.nextLine();
        System.out.print("Introduzca la cantidad a retirar: ");
        double cantidad = scanner.nextDouble();
        scanner.nextLine();
        manager.retirarDeCuenta(idCuenta, cantidad);
    }
    
    /**
     * Método encargado de recoger los datos necesarios para iniciar una transferencia.
     * @param scanner	Scanner es una utilidad la cual recoge lo que escriba el usuario
     */
    private static void uiTransferencia(Scanner scanner) {
        System.out.print("Cuenta emisora: ");
        String cuentaOrigen = scanner.nextLine();
        System.out.print("Cuenta receptora: ");
        String cuentaDestino = scanner.nextLine();
        System.out.print("Cantidad a transferir: ");
        double cantidad = scanner.nextDouble();
        scanner.nextLine();
        manager.transferirEntreCuentas(cuentaOrigen, cuentaDestino, cantidad);
    }
}