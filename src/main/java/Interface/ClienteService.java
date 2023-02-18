package Interface;

import model.Cliente;

/**
 * @author CrisMoura on 18/02/2023
 */
public interface ClienteService {

    public boolean criarCliente(Cliente cliente);

    public Cliente getClientePorId(Integer id);


}
