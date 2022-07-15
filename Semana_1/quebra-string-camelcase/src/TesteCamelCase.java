import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.graalvm.compiler.debug.Assertions;
import org.junit.jupiter.api.Test;

class TesteCamelCase {
	ArrayList<String> primeiraPalavra, segundoPalavra, terceiraPalavra, quartaPalavra;
	
	ArrayList<String> palavraInvalida1, palavraInvalida2;

	// Primeiro Teste nome - "nome"
	@Test
	public void testePalavraMinuscula() {
		primeiraPalavra = new ArrayList<>();
		primeiraPalavra.add("nome");
		assertEquals("nome", CamelCase.palavraMinuscula("nome"));
	}

	// Segundo Teste Nome - "nome"
	@Test
	public void teste2PalavraMinuscula() {
		segundoPalavra = new ArrayList<>();
		segundoPalavra.add("Nome");
		assertEquals("nome", CamelCase.palavraMinuscula("Nome"));
	}

	// Terceiro nomeComposto - “nome”, “composto”
	public void inicializaCamelCase() {
		terceiraPalavra = new ArrayList<>();
		terceiraPalavra.add("numero");
		terceiraPalavra.add("CPF");
		terceiraPalavra.add("contribuinte");
	}

	@Test
	public void testeConverterCamelCase() {
		inicializaCamelCase();
		assertArrayEquals(terceiraPalavra.toArray(), CamelCase.converterCamelCase("numeroCPFContribuinte").toArray());
	}

	@Test
	public void testeQuebraTexto() {
		inicializaCamelCase();
		assertArrayEquals(terceiraPalavra.toArray(), CamelCase.quebraTexto("numeroCPFContribuinte").toArray());
	}

	@Test
	public void testeTodosInicioMaiusculo() {
		inicializaCamelCase();
		assertArrayEquals(terceiraPalavra.toArray(), CamelCase.converterCamelCase("numeroCPFContribuinte").toArray());
	}

	@Test
	public void testeTudoMaiusculo() {
		inicializaCamelCase();
		assertArrayEquals(terceiraPalavra.toArray(), CamelCase.converterCamelCase("numeroCPFContribuinte").toArray());
	}

	// Quarto teste numeroCPFContribuinte - “numero”, “CPF”, “contribuinte”

	public void numeroMeio() {
		quartaPalavra = new ArrayList<>();
		quartaPalavra.add("recupera");
		quartaPalavra.add("10");
		quartaPalavra.add("primeiros");
		assertArrayEquals(quartaPalavra.toArray(), CamelCase.converterCamelCase("recupera10Primeiros").toArray());
	}
	// Teste de erro iniciando com numero no inicio
	@Test
	public void numeroInicio(){
		
		 ConvertException thrown = assertThrows(ConvertException.class, () -> {
			 	palavraInvalida1 = new ArrayList<>();
				palavraInvalida1.add("10");
				palavraInvalida1.add("primeiros");
			 assertArrayEquals(palavraInvalida1.toArray() , CamelCase.converterCamelCase("10primeiros").toArray());
	  });

	}
	
	// Teste de erro usandoCaracteres
	@Test
	public void usandoCaracteres(){
		
		 ConvertException thrown = assertThrows(ConvertException.class, () -> {
			 	palavraInvalida2 = new ArrayList<>();
				palavraInvalida2.add("nome");
				palavraInvalida2.add("#");
				palavraInvalida2.add("Composto");
			 assertArrayEquals(palavraInvalida2.toArray() , CamelCase.converterCamelCase("nome#Composto").toArray());
	  });

	}
	
}

