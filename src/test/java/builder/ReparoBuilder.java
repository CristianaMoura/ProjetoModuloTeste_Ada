package builder;

import enums.StatusReparo;
import enums.TabelaPreco;
import enums.TipoReparo;
import model.Celular;
import model.Cliente;
import model.Reparo;

import java.util.Date;

/**
 * @author CrisMoura on 18/02/2023
 */
public class ReparoBuilder {

    public static Reparo getReparoSimples() {
        Reparo reparo = new Reparo(1l, ClienteBuilder.getCliente1(), new Date(),null,TipoReparo.REPARO_SIMPLES, null, null);

        return reparo;
    }

    public static Reparo getReparoCompleto() {
        Reparo reparo = new Reparo(2l, ClienteBuilder.getCliente2(), new Date(),null,TipoReparo.REPARO_COMPLETO, null, null);

        return reparo;
    }
}
