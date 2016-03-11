package com.jucelinux;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ValidadorUtilTest {

	@Test
	public void testeValidadorExpressao() {
	
		assertTrue("Rever médoto de validação de expressão. Era experado retorno 'true' para expressão bem formada", ValidadorUtil.validaExpressao("([{a}])"));
		assertFalse("Rever médoto de validação de expressão. Era experado retorno 'false' para expressão mal formada", ValidadorUtil.validaExpressao("((((a){{{b,c"));
		assertFalse("Rever médoto de validação de expressão. Era experado retorno 'false' para expressão mal formada", ValidadorUtil.validaExpressao("{([abc)]}"));
	
	}
}
