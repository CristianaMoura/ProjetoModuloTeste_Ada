package enums;

import java.math.BigDecimal;

/**
 * @author CrisMoura on 18/02/2023
 */
public enum TabelaPreco {
    
    VALOR_REPARO_SIMPLES(new BigDecimal(100)),
    VALOR_REPARO_COMPLETO(new BigDecimal(200));


    public final BigDecimal valor;
    TabelaPreco(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor(){
        return valor;
    }
}
