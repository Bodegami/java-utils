package br.ce.wcaquino.servicos;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.entidades.Usuario;



public class AssertTest {
	
	@Test
	public void test() {
		
		Assert.assertTrue(true);
		Assert.assertFalse(false);
		
		//para tipos numericos o comportamento é o mesmo
		Assert.assertEquals(1, 1);
		
		//para tipos double/float, precisamos passar um delta no final da expressão
		//o delta representa a margem de erro para comparacao
		Assert.assertEquals(0.51, 0.52, 0.1);
		//Assert.assertEquals(0.51, 0.52, 0.01); -> falha, pois a margem de erro é menor que a comparacao acima
		Assert.assertEquals(Math.PI, 3.14, 0.01);
		
		//o junit não permite comparações de tipo primitivo e wrappers
		//para isso é necessario fazer o unboxing/autoboxing manualmente
		int i = 5;
		Integer i2 = 5;
		//Assert.assertEquals(i, i2); -> não permite a comparação
		Assert.assertEquals(i, i2.intValue());
		Assert.assertEquals(Integer.valueOf(i), i2);
		
		//comparações de String, que precisam ignorar se uma letra é maiuscula ou nao, precisam
		// utilizar o assertTrue com alguns metodos especiais da classe String
		Assert.assertEquals("bola", "bola");
		Assert.assertNotEquals("bola", "Bola"); //falha na comparação usando assertEquals
		Assert.assertTrue("bola".equalsIgnoreCase("Bola"));
		Assert.assertTrue("bola".startsWith("bo"));
		
		
		//Para classes especificas da aplicacao, ao fazer a comparacao como no exemplo abaixo
		//é preciso que a classe tenha o metodo equals implementado, caso contrario, ele 
		//vai utilizar o metodo equals da classe mae Object(compara se o obj e o mesmo que o outro)
		Usuario u1 = new Usuario("Usuario 1");
		Usuario u2 = new Usuario("Usuario 1");
		Usuario u3 = null;
		Assert.assertEquals(u1, u2);
		
		//caso a intenção fosse comparar se os objetos dão da mesms instância, podemos utilizar
		//o metodo assertSame
		Assert.assertNotSame(u1, u2); //falha pois são instâncias diferentes usando assertSame
		Assert.assertSame(u2, u2);
		
		//comparação para objetos nulos ou não nulos
		Assert.assertTrue(u3 == null);
		Assert.assertNull(u3);
		Assert.assertNotNull(u2);
		
		
		//também é possivel printar um texto especificio em caso de falha
		Assert.assertEquals("falha na comparação", 1, 1);
		
		//As comparações tem uma ordem que é esperado do lado esquerdo e atual do lado direto
		Assert.assertNotEquals("esperado", "atual");
		
		
		
		
		
		
		
	}

}
