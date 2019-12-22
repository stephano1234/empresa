package br.com.contmatic.repository.configuracao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ConexaoTest {
	
	Conexao conexao;

	Conexao outraConexao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		conexao = Conexao.getInstance();
		outraConexao = Conexao.getInstance();		
	}

	@After
	public void tearDown() throws Exception {
		conexao.getMongoClient().close();
		outraConexao.getMongoClient().close();
	}

	@Test
	public void verifica_construtor_nao_pode_ser_instanciado() {
		try {
			Conexao.class.getDeclaredConstructors()[0].newInstance();
			fail();
		} catch (Exception e) {
		}
	}

	@Test
	public void verifica_se_nao_cria_um_novo_objeto_quando_um_objeto_ja_existe() {	
			assertTrue(conexao == outraConexao);
	}

	@Test
	public void verifica_se_nao_cria_uma_nova_conexao_com_o_banco_quando_uma_conexao_ja_existe() {	
			assertTrue(conexao.getMongoClient() == outraConexao.getMongoClient());
	}
	
}
