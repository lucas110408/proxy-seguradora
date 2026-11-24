package proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SeguradoProxyTest {

    @BeforeEach
    void setUp() {
        BD.addSegurado(new Segurado(1, "Carlos", "Juiz de Fora", 1500.0f, 800.0f));
        BD.addSegurado(new Segurado(2, "Ana", "Juiz de Fora", 3000.0f, 0.0f));
    }

    @Test
    void deveRetornarDadosPessoaisSegurado() {
        SeguradoProxy segurado = new SeguradoProxy(1);

        assertEquals(Arrays.asList("Carlos", "Juiz de Fora"), segurado.obterDadosPessoais());
    }

    @Test
    void deveRetornarValoresSinistrosSegurado() {
        Funcionario funcionario = new Funcionario("Paulo", true);
        SeguradoProxy segurado = new SeguradoProxy(2);

        assertEquals(Arrays.asList(3000.0f, 0.0f), segurado.obterValoresSinistros(funcionario));
    }

    @Test
    void deveRetornarExcecaoFuncionarioNaoAutorizadoConsultarSinistros() {
        try {
            Funcionario funcionario = new Funcionario("Joana", false);
            SeguradoProxy segurado = new SeguradoProxy(2);

            segurado.obterValoresSinistros(funcionario);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Funcionário não autorizado", e.getMessage());
        }
    }
}
