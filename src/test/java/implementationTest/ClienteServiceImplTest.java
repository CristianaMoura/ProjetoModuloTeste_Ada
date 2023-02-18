package implementationTest;

import Implementation.ClienteServiceImpl;
import Interface.ClienteService;
import builder.ClienteBuilder;
import model.Celular;
import model.Cliente;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * @author CrisMoura on 18/02/2023
 */
@RunWith(MockitoJUnitRunner.class)
public class ClienteServiceImplTest {


    @Test
    public void deveCriarClienteCorretamente(){

        // Given
        Cliente cliente = ClienteBuilder.getCliente1();
        ClienteService clienteService = new ClienteServiceImpl();
        // When

        // Then
        assertTrue(clienteService.criarCliente(cliente));

       }

    @Test
    public void naoDeveCriarClienteDuplicado(){

        // Given
        Cliente cliente = ClienteBuilder.getCliente1();
        ClienteService clienteService = new ClienteServiceImpl();

        // When
        clienteService.criarCliente(cliente);

        // Then
        assertFalse(clienteService.criarCliente(cliente));

    }

    @Test
    public void naoDeveMostrarClienteCasoPasseIdIncorreto(){

        // Given
        Cliente cliente = ClienteBuilder.getCliente1();
        ClienteService clienteService = new ClienteServiceImpl();

        // When
        clienteService.criarCliente(cliente);
        Cliente clienteRetornado = clienteService.getClientePorId(44);

        // Then
        assertNull(clienteRetornado);

    }


    @Test
    public void naoDeveConsultarClienteCorretamente(){

        // Given
        Cliente cliente = ClienteBuilder.getCliente1();
        ClienteService clienteService = new ClienteServiceImpl();

        // When
        clienteService.criarCliente(cliente);
        Cliente clienteRetornado = clienteService.getClientePorId(cliente.getId());

        // Then
        assertEquals(cliente.getId(), clienteRetornado.getId());
        assertEquals(cliente.getNome(), clienteRetornado.getNome());
        assertEquals(cliente.getTelefone(), clienteRetornado.getTelefone());
        assertEquals(cliente.getCelular().getModelo(), clienteRetornado.getCelular().getModelo());
        assertEquals(cliente.getCelular().getMarca(), clienteRetornado.getCelular().getMarca());

    }

}

