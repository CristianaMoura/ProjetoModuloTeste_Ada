package Interface;

import Exceptions.StatusReparoException;
import enums.StatusReparo;
import model.Celular;
import model.Reparo;

/**
 * @author CrisMoura on 17/02/2023
 */
public interface ReparoService {

    public boolean criarReparo(Reparo reparo);
    public void fazerReparo(Reparo reparo);

    public StatusReparo statusReparo(Long id);

    public void baixaReparo(Reparo reparo) throws StatusReparoException;

    public Reparo getReparoPorId(Long id);


}
