package Banking;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase es la encargada de la gestión de las cuentas del banco, como puede ser
 * el crear una cuenta, depositar o retirar dinero, transferencias etc.
 */

public class Management {
	
	/**
	 * Crea una nueva instancia de la clase Cuenta banco.
	 */
    private List<CuentaBanco> cuentas = new ArrayList<>();

    /**
     * Método encargado de crear una cuenta.
     * @param idCuenta	el identificador a utilizar.
     * @param propietarioCuenta	proprietario de la cuenta en cuestión.
     */
    public void crearCuenta(String idCuenta, String propietarioCuenta) {
        CuentaBanco nuevaCuenta = new CuentaBanco(idCuenta, propietarioCuenta);
        cuentas.add(nuevaCuenta);
        System.out.println("Nueva cuenta creada a nombre de " + propietarioCuenta + " con número: " + idCuenta);
    }

    /**
     * Método encargada de encontrar la instancia deseada en base al ID.
     * @param idCuenta	identificador de la cuenta.
     * @return	Devuelve la cuenta en cuestión.
     */
    private CuentaBanco encontrarCuenta(String idCuenta) {
        for (CuentaBanco cuenta : cuentas) {
            if (cuenta.getNumeroCuenta().equals(idCuenta)) {
                return cuenta;
            }
        }
        return null;
    }

    /**
     * Método encargado de depositar dinero a una cuenta.
     * @param idCuenta	Identificador de la cuenta a la que añadir dinero.
     * @param cantidad	Cantidad a añadir.
     */
    public void depositarACuenta(String idCuenta, double cantidad) {
        CuentaBanco cuenta = encontrarCuenta(idCuenta);
        if (cuenta != null) {
            cuenta.depositar(cantidad);
        } else {
            System.out.println("Cuenta no encontrada.");
        }
    }

    /**
     * Método encargado de retirar dinero a una cuenta.
     * @param idCuenta	Identificador de la cuenta a la que retirar dinero.
     * @param cantidad	Cantidad a retirar.
     */
    public void retirarDeCuenta(String idCuenta, double cantidad) {
        CuentaBanco cuenta = encontrarCuenta(idCuenta);
        if (cuenta != null) {
            cuenta.retirar(cantidad);
        } else {
            System.out.println("Cuenta no encontrada.");
        }
    }

    /**
     * Método para transferir dinero entre cuentas.
     * @param cuentaOrigen	Cuenta de origen, la cual enviará el dinero.
     * @param cuentaDestino	Cuenta de destino, la cual recibirá el dinero.
     * @param cantidad	Cantidad de dinero a transferir.
     */
    public void transferirEntreCuentas(String cuentaOrigen, String cuentaDestino, double cantidad) {
        CuentaBanco deCuenta = encontrarCuenta(cuentaOrigen);
        CuentaBanco haciaCuenta = encontrarCuenta(cuentaDestino);
        if (deCuenta != null && haciaCuenta != null) {
            deCuenta.transferir(haciaCuenta, cantidad);
        } else {
            System.out.println("Una o ambas cuentas no se han podido encontrar.");
        }
    }

    /**
     * Método encargado de encontrar una cuenta
     */
    public void mostrarCuentas() {
        for (CuentaBanco cuenta : cuentas) {
            cuenta.mostrarDetallesCuenta();
        }
    }
}