package builder;

import enums.TipoReparo;
import model.Celular;
import model.Cliente;

/**
 * @author CrisMoura on 18/02/2023
 */
public class ClienteBuilder {

    public static Cliente getCliente1() {
        Celular celular = new Celular("APPLE", "IPhone11", 1);
        Cliente cliente = new Cliente("Cristiana", "11988885566", 1, celular);
        return cliente;
    }

    public static Cliente getCliente2() {
        Celular celular = new Celular("SAMSUNG", "Galaxy S21", 2);
        Cliente cliente = new Cliente("Fabio", "1197775511", 2, celular);
        return cliente;
    }
}
