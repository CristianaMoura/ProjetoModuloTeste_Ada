package implementationTest;

import Exceptions.StatusReparoException;
import Implementation.ReparoServiceImpl;
import Interface.ReparoService;
import builder.ReparoBuilder;
import enums.StatusReparo;
import model.Reparo;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author CrisMoura on 18/02/2023
 */
public class ReparoServiceImplTest {

    @Test
    public void deveCriarReparoCorretamente(){

        // Given
        Reparo reparo = ReparoBuilder.getReparoSimples();
        ReparoService reparoService = new ReparoServiceImpl();
        // When

        // Then
        assertTrue(reparoService.criarReparo(reparo));

    }

    @Test
    public void naoDeveCriarReparoDuplicado(){

        // Given
        Reparo reparo = ReparoBuilder.getReparoSimples();
        ReparoService reparoService = new ReparoServiceImpl();

        // When
        reparoService.criarReparo(reparo);
        // Then
        assertFalse(reparoService.criarReparo(reparo));

    }

    @Test
    public void deveFazerReparoSimples(){

        // Given
        Reparo reparo = ReparoBuilder.getReparoSimples();
        ReparoService reparoService = new ReparoServiceImpl();

        // When
        reparoService.criarReparo(reparo);
        reparoService.fazerReparo(reparo);
        // Then
        assertEquals(new BigDecimal(100),reparo.getValorReparo().getValor());
        assertEquals(StatusReparo.EM_ANDAMENTO,reparo.getStatusReparo());

    }

    @Test
    public void deveFazerReparoCompleto(){

        // Given
        Reparo reparo = ReparoBuilder.getReparoCompleto();
        ReparoService reparoService = new ReparoServiceImpl();

        // When
        reparoService.criarReparo(reparo);
        reparoService.fazerReparo(reparo);
        // Then
        assertEquals(new BigDecimal(200),reparo.getValorReparo().getValor());
        assertEquals(StatusReparo.REPARO_EM_ANALISE,reparo.getStatusReparo());

    }

    @Test
    public void deveMostrarStatusDoReparo(){

        // Given
        Reparo reparo = ReparoBuilder.getReparoCompleto();
        ReparoService reparoService = new ReparoServiceImpl();

        // When
        reparoService.criarReparo(reparo);
        reparoService.fazerReparo(reparo);
        StatusReparo statusReparo = reparoService.statusReparo(reparo.getId());
        // Then
        assertEquals(StatusReparo.REPARO_EM_ANALISE,statusReparo);

    }

    @Test
    public void naoDeveTrazerReparoCasoOIdPassadoSejaErrado(){

        // Given
        Reparo reparo = ReparoBuilder.getReparoCompleto();
        ReparoService reparoService = new ReparoServiceImpl();

        // When
        reparoService.criarReparo(reparo);
        Reparo reparoRetornado = reparoService.getReparoPorId(44L);
        // Then
        assertNull(reparoRetornado);

    }

    @Test
    public void naoDeveMostrarStatusCasoOIdPassadoSejaErrado(){

        // Given
        Reparo reparo = ReparoBuilder.getReparoCompleto();
        ReparoService reparoService = new ReparoServiceImpl();

        // When
        reparoService.criarReparo(reparo);
        StatusReparo statusReparoRetornado = reparoService.statusReparo(44L);
        // Then
        assertNull(statusReparoRetornado);

    }

    @Test
    public void deveEfetuarBaixaDoReparo() throws StatusReparoException {

        // Given
        Reparo reparo = ReparoBuilder.getReparoCompleto();
        ReparoService reparoService = new ReparoServiceImpl();

        // When
        reparoService.criarReparo(reparo);
        reparoService.fazerReparo(reparo);
        reparo.setStatusReparo(StatusReparo.EM_ANDAMENTO);
        reparoService.baixaReparo(reparo);

        // Then
        assertEquals(StatusReparo.REPARO_FINALIZADO,reparo.getStatusReparo());

    }

    @Test
    public void deveLancarExceptionCasoOReparoEstejaComStatusDiferenteDeAndamento() throws StatusReparoException {

        // Given
        Reparo reparo = ReparoBuilder.getReparoCompleto();
        ReparoService reparoService = new ReparoServiceImpl();

        // When
        reparoService.criarReparo(reparo);
        reparoService.fazerReparo(reparo);

        Assertions.assertThrows(StatusReparoException.class, () -> reparoService.baixaReparo(reparo));

    }

    @Test
    public void deveMostrarReparo(){

        // Given
        Reparo reparo = ReparoBuilder.getReparoCompleto();
        ReparoService reparoService = new ReparoServiceImpl();

        // When
        reparoService.criarReparo(reparo);
        Reparo reparoRetornado = reparoService.getReparoPorId(reparo.getId());

        // Then
        assertEquals(reparo.getId(),reparoRetornado.getId());
        assertEquals(reparo.getTipoReparo(),reparoRetornado.getTipoReparo());
        assertEquals(reparo.getDataInicioReparo(),reparoRetornado.getDataInicioReparo());
        assertEquals(reparo.getDataFimReparo(),reparoRetornado.getDataFimReparo());
        assertEquals(reparo.getValorReparo(),reparoRetornado.getValorReparo());
        assertEquals(reparo.getCliente().getId(),reparoRetornado.getCliente().getId());
        assertEquals(reparo.getCliente().getNome(),reparoRetornado.getCliente().getNome());
        assertEquals(reparo.getCliente().getCelular(),reparoRetornado.getCliente().getCelular());
        assertEquals(reparo.getCliente().getTelefone(),reparoRetornado.getCliente().getTelefone());
        assertEquals(reparo.getCliente().getCelular().getMarca(),reparoRetornado.getCliente().getCelular().getMarca());
        assertEquals(reparo.getCliente().getCelular().getId(),reparoRetornado.getCliente().getCelular().getId());
        assertEquals(reparo.getCliente().getCelular().getModelo(),reparoRetornado.getCliente().getCelular().getModelo());
    }


}
