/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.ufes.autorizacaopagamento.business.DiretorFinanceiro;
import com.ufes.autorizacaopagamento.business.DiretorGeral;
import com.ufes.autorizacaopagamento.business.GerenteGeral;
import com.ufes.autorizacaopagamento.business.GerenteImediato;
import com.ufes.autorizacaopagamento.business.ProcessaPagamentoService;
import static java.util.Arrays.asList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author Aluno
 */
public class DriverAprovacaoPagamentoDisponiveis {

    private static ProcessaPagamentoService processador = new ProcessaPagamentoService();

    public DriverAprovacaoPagamentoDisponiveis() {

    }

    @BeforeAll
    public static void iniciar() {
        processador.addTratador(new GerenteImediato(true));
        processador.addTratador(new GerenteGeral(true));
        processador.addTratador(new DiretorFinanceiro(true));
        processador.addTratador(new DiretorGeral(true));
    }

    @Test
    public void CT001() {
        //Arrange
        int valor = 500;

        List<String> esperadoGI = asList("\r\nGerente imediato autorizando pagamento no valor de R$ 500.0");

        //Act
        List<String> valorObtido = asList(processador.processaAprovacao(valor));

        //Assert
        assertLinesMatch(esperadoGI, valorObtido);
    }

    @Test
    public void CT002() {
        //Arrange
        int valor = 501;

        String esperadoGI = "\r\nGerente imediato não pôde aprovar o pagamento solicitado\r\nGerente Geral autorizando pagamento no valor de R$ 501.0";

        //Act
        String valorObtido = processador.processaAprovacao(valor);
        System.out.println(processador.processaAprovacao(valor));

        //Assert
        assertEquals(esperadoGI, valorObtido);
    }

    @Test
    public void CT003() {
        //Arrange
        int valor = 1500;

        String esperadoGI = "\r\nGerente imediato não pôde aprovar o pagamento solicitado\r\nGerente Geral autorizando pagamento no valor de R$ 1500.0";

        //Act
        String valorObtido = processador.processaAprovacao(valor);
        System.out.println(processador.processaAprovacao(valor));

        //Assert
        assertEquals(esperadoGI, valorObtido);
    }

    @Test
    public void CT004() {
        //Arrange
        int valor = 1501;

        String esperadoGI = "\r\nGerente imediato não pôde aprovar o pagamento solicitado"
                + "\r\nGerente Geral não pôde aprovar o pagamento solicitado"
                + "\r\nDiretor financeiro autorizando pagamento no valor de R$ 1501.0";

        //Act
        String valorObtido = processador.processaAprovacao(valor);
        System.out.println(processador.processaAprovacao(valor));

        //Assert
        assertEquals(esperadoGI, valorObtido);
    }

    @Test
    public void CT005() {
        //Arrange
        int valor = 5000;

        String esperadoGI = "\r\nGerente imediato não pôde aprovar o pagamento solicitado"
                + "\r\nGerente Geral não pôde aprovar o pagamento solicitado"
                + "\r\nDiretor financeiro autorizando pagamento no valor de R$ 5000.0";

        //Act
        String valorObtido = processador.processaAprovacao(valor);
        System.out.println(processador.processaAprovacao(valor));

        //Assert
        assertEquals(esperadoGI, valorObtido);
    }

    @Test
    public void CT006() {
        //Arrange
        int valor = 5001;

        String esperadoGI = "\r\nGerente imediato não pôde aprovar o pagamento solicitado"
                + "\r\nGerente Geral não pôde aprovar o pagamento solicitado"
                + "\r\nDiretor financeiro não pôde aprovar o pagamento solicitado"
                + "\r\nDiretor Geral autorizando pagamento no valor de R$ 5001.0";
        //Act
        String valorObtido = processador.processaAprovacao(valor);
        System.out.println(processador.processaAprovacao(valor));

        //Assert
        assertEquals(esperadoGI, valorObtido);
    }
    
    @Test
    public void CT007() {
        //Arrange
        int valor = 15000;

        String esperadoGI = "\r\nGerente imediato não pôde aprovar o pagamento solicitado"
                + "\r\nGerente Geral não pôde aprovar o pagamento solicitado"
                + "\r\nDiretor financeiro não pôde aprovar o pagamento solicitado"
                + "\r\nDiretor Geral autorizando pagamento no valor de R$ 15000.0";
        //Act
        String valorObtido = processador.processaAprovacao(valor);
        System.out.println(processador.processaAprovacao(valor));

        //Assert
        assertEquals(esperadoGI, valorObtido);
    }
}
