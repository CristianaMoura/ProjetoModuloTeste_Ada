package Implementation;

import Interface.ClienteService;
import model.Cliente;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CrisMoura on 18/02/2023
 */
public class ClienteServiceImpl  implements ClienteService {


    List<Cliente> listaClientes = new ArrayList<>();


    @Override
    public boolean criarCliente(Cliente cliente) {

        for(Cliente cli : listaClientes) {
           if (cliente.getId().equals(cli.getId())){
               System.out.println("cliente ja possui cadastro");
               return false;
           }
        }

        listaClientes.add(cliente);
        System.out.println("Cliente adicionado com sucesso");
        return true;
    }

    @Override
    public Cliente getClientePorId(Integer id) {

        for(int i = 0; i < listaClientes.size(); i++){
            if (listaClientes.get(i).getId().equals(id)){
                return listaClientes.get(i);
            }
        }

        return null;
    }
}
