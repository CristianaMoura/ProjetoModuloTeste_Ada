package model;

import enums.StatusReparo;
import enums.TabelaPreco;
import enums.TipoReparo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author CrisMoura on 18/02/2023
 */
public class Reparo {


    private Long id;
    private Cliente cliente;
    private Date dataInicioReparo;
    private Date dataFimReparo;
    private TipoReparo tipoReparo;

    private StatusReparo statusReparo;

    private TabelaPreco valorReparo;


    public Reparo(Long id, Cliente cliente, Date dataInicioReparo, Date dataFimReparo, TipoReparo tipoReparo, StatusReparo statusReparo, TabelaPreco valorReparo) {
        this.id = id;
        this.cliente = cliente;
        this.dataInicioReparo = dataInicioReparo;
        this.dataFimReparo = dataFimReparo;
        this.tipoReparo = tipoReparo;
        this.statusReparo = statusReparo;
        this.valorReparo = valorReparo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataInicioReparo() {
        return dataInicioReparo;
    }

    public void setDataInicioReparo(Date dataInicioReparo) {
        this.dataInicioReparo = dataInicioReparo;
    }

    public Date getDataFimReparo() {
        return dataFimReparo;
    }

    public void setDataFimReparo(Date dataFimReparo) {
        this.dataFimReparo = dataFimReparo;
    }

    public TipoReparo getTipoReparo() {
        return tipoReparo;
    }

    public void setTipoReparo(TipoReparo tipoReparo) {
        this.tipoReparo = tipoReparo;
    }

    public StatusReparo getStatusReparo() {
        return statusReparo;
    }

    public void setStatusReparo(StatusReparo statusReparo) {
        this.statusReparo = statusReparo;
    }

    public TabelaPreco getValorReparo() {
        return valorReparo;
    }

    public void setValorReparo(TabelaPreco valorReparo) {
        this.valorReparo = valorReparo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
