package Implementation;

import Exceptions.StatusReparoException;
import Interface.ReparoService;
import enums.StatusReparo;
import enums.TabelaPreco;
import enums.TipoReparo;
import model.Cliente;
import model.Reparo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CrisMoura on 16/02/2023
 */
public class ReparoServiceImpl implements ReparoService {

    List<Reparo> listaReparos = new ArrayList<>();

    @Override
    public boolean criarReparo(Reparo reparo) {

        for(Reparo rep : listaReparos) {
            if (rep.getId().equals(reparo.getId())){
                System.out.println("reparo ja possui cadastro");
                return false;
            }
        }

        listaReparos.add(reparo);
        System.out.println("Reparo adicionado com sucesso");
        return true;
    }

    @Override
    public void fazerReparo(Reparo reparo) {

        if(reparo.getTipoReparo().equals(TipoReparo.REPARO_SIMPLES)){
            reparo.setStatusReparo(StatusReparo.EM_ANDAMENTO);
            reparo.setValorReparo(TabelaPreco.VALOR_REPARO_SIMPLES);
        }else{
            reparo.setStatusReparo(StatusReparo.REPARO_EM_ANALISE);
            reparo.setValorReparo(TabelaPreco.VALOR_REPARO_COMPLETO);
        }
    }

    @Override
    public StatusReparo statusReparo(Long id) {
        for(Reparo reparo : listaReparos) {
            if (reparo.getId().equals(id)){
               return reparo.getStatusReparo();
            }
        }

        return null;
    }

    @Override
    public void baixaReparo(Reparo reparo) throws StatusReparoException {
        if (reparo.getStatusReparo().equals(StatusReparo.EM_ANDAMENTO)){
            reparo.setStatusReparo(StatusReparo.REPARO_FINALIZADO);
        }else{
            throw new StatusReparoException();
        }

        System.out.println("Reparo Finalizado com sucesso!!!");
    }

    @Override
    public Reparo getReparoPorId(Long id) {
        for(Reparo reparo : listaReparos) {
            if (reparo.getId().equals(id)){
                return reparo;
            }
        }

        return null;
    }

}
