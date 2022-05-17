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
import org.junit.jupiter.api.DisplayName;

/**
 *
 * @author Aluno
 */
public class DriverAprovacaoPagamentoIndisponiveis {

    private static ProcessaPagamentoService processador = new ProcessaPagamentoService();

    public DriverAprovacaoPagamentoIndisponiveis() {

    }
    
    @DisplayName("Teste01: Gerente imediato indisponível, e o resto trabalhando")
    @Test
    public void CT001() {
        //Arrange
        processador.addTratador(new GerenteImediato(false));
        processador.addTratador(new GerenteGeral(true));
        processador.addTratador(new DiretorFinanceiro(true));
        processador.addTratador(new DiretorGeral(true));
        int valor = 500;

        String esperadoGI = "\r\nGerente imediato não pôde aprovar o pagamento solicitado\r\nGerente Geral autorizando pagamento no valor de R$ 500.0";

        //Act
        String valorObtido = processador.processaAprovacao(valor);

        //Assert
        assertEquals(esperadoGI, valorObtido);
    }

    @Test
    public void CT002() {
        //Arrange
        processador.addTratador(new GerenteImediato(false));
        processador.addTratador(new GerenteGeral(false));
        processador.addTratador(new DiretorFinanceiro(true));
        processador.addTratador(new DiretorGeral(true));
        int valor = 500;

        String esperadoGI = "\r\nGerente imediato não pôde aprovar o pagamento solicitado"
                + "\r\nGerente Geral não pôde aprovar o pagamento solicitado"
                + "\r\n Diretor financeiro autorizando pagamento no valor de R$ 500.0";

        //Act
        String valorObtido = processador.processaAprovacao(valor);

        //Assert
        assertEquals(esperadoGI, valorObtido);
    }

    @Test
    public void CT003() {
        //Arrange
        processador.addTratador(new GerenteImediato(false));
        processador.addTratador(new GerenteGeral(false));
        processador.addTratador(new DiretorFinanceiro(false));
        processador.addTratador(new DiretorGeral(true));
        int valor = 500;

        String esperadoGI = "\r\nGerente imediato não pôde aprovar o pagamento solicitado"
                + "\r\nGerente Geral não pôde aprovar o pagamento solicitado"
                + "\r\nDiretor financeiro não pôde aprovar o pagamento solicitado"
                + "\r\n Diretor Geral autorizando pagamento no valor de R$ 500.0";

        //Act
        String valorObtido = processador.processaAprovacao(valor);

        //Assert
        assertEquals(esperadoGI, valorObtido);
    }

    @Test
    public void CT004() {
        //Arrange
        processador.addTratador(new GerenteImediato(false));
        processador.addTratador(new GerenteGeral(false));
        processador.addTratador(new DiretorFinanceiro(false));
        processador.addTratador(new DiretorGeral(false));
        int valor = 500;

        String esperadoGI = "\r\nGerente imediato não pôde aprovar o pagamento solicitado\r\nGerente Geral autorizando pagamento no valor de R$ 500.0";

        //Act
        String valorObtido = processador.processaAprovacao(valor);

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
