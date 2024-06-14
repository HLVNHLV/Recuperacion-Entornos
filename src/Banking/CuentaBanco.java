package Banking;


/**
 * Esta clase tiene la lógica para la gestión o creación de las cuentas.
 */
public class CuentaBanco {
	/**
	 * Identificador de cuenta.
	 */
    private String idCuenta;
	/**
	 * Propietario de la cuenta.
	 */
    private String propietarioCuenta;
	/**
	 * Saldo de la cuenta.
	 */
    private double balance;

    /**
     * Constructor el cual tiene los parámetros de la cuenta, se usa para hacer instancias de este por cada cuenta.
     * @param idCuenta	Es el número o ID a utilizar para identificar la cuenta.
     * @param propietarioCuenta	Es el nombre del propietario de la cuenta.
     */
    public CuentaBanco(String idCuenta, String propietarioCuenta) {
        this.idCuenta = idCuenta;
        this.propietarioCuenta = propietarioCuenta;
        this.balance = 0.0;
    }
    
    /**
     * Método encargado de depositar el dinero indicado a una cuenta.
     * @param cantidad	Cantidad de dinero a ingresar, debe ser un número positivo, tipo double.
     */
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            balance += cantidad;
            System.out.println("Cantidad depositada con éxito, nuevo balance : " + balance);
        } else {
            System.out.println("Cantidad inválida, introduzca un número positivo.");
        }
    }

    /**
     * Método encargado de retirar el dinero indicado a una cuenta.
     * @param cantidad	Cantidad de dinero a retirar, debe ser un número positivo, tipo double.
     */
    public void retirar(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("Cantidad inválida, introduzca un número positivo.");
        } else if (cantidad > balance) {
            System.out.println("Balance insuficiente, trasnferencia fallida.");
        } else {
            balance -= cantidad;
            System.out.println("Cantidad retirada con éxito, nuevo balance : " + balance);
        }
    }

    /**
     * Método encargado de la transferencia de dinero entre cuentas.
     * @param cuentaDestino Identificador de la cuenta de destino.
     * @param cantidad	Cantidad de dinero a transferir entre cuentas.
     */
    public void transferir(CuentaBanco cuentaDestino, double cantidad) {
        if (cantidad <= balance) {
            this.retirar(cantidad);
            cuentaDestino.depositar(cantidad);
            System.out.println("Transferencia realizada con éxito, nuevo balance : " + this.balance);
        } else {
            System.out.println("Balance insuficiente, trasnferencia fallida.");
        }
    }

    /**
     * Mostrar detalles de una cuenta especificada por pantalla.
     */
    public void mostrarDetallesCuenta() {
        System.out.println("Número de cuenta: " + idCuenta + ", Propietario: " + propietarioCuenta + ", Balance: " + balance);
    }

    /**
     * Getter para obtener el identificador de una cuenta.
     * @return	el identificador de dicha cuenta.
     */
    public String getNumeroCuenta() { return idCuenta; }
    
    /**
     * Setter para crear el identificador de una cuenta.
     * @param idCuenta	el identificador de dicha cuenta.
     */
    public void setNumeroCuenta(String idCuenta) { this.idCuenta = idCuenta; }
    
    /**
     * Getter para obtener el propetario de una cuenta.
     * @return	el propietario de dicha cuenta.
     */
    public String getPropietarioCuenta() { return propietarioCuenta; }
    
    /**
     * setter para crear el propetario de una cuenta.
     * @param propietarioCuenta	el propietario de dicha cuenta.
     */
    public void setPropietarioCuenta(String propietarioCuenta) { this.propietarioCuenta = propietarioCuenta; }
    
    /**
     * Getter para obtener el saldo de una cuenta.
     * @return	saldo de dicha cuenta.
     */
    public double getSaldo() { return balance; }
}