package mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class CalculadoraTest {

    @Mock
    private ServicoMatematico servicoMatematico = mock(ServicoMatematico.class);

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void somaTest(){
        when(servicoMatematico.somar(2,3)).thenReturn(5);

        Calculadora calculadora = new Calculadora(servicoMatematico);
        int resultado = calculadora.somar(2, 3);
        assertEquals(5, resultado);
        verify(servicoMatematico).somar(2,3);
    }
}