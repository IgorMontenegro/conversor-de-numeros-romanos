package ufg.tacs.conversor_de_numeros_romanos;

import org.testng.annotations.Test;

import junit.framework.TestCase;

public class ConverterPararRomanoTest extends TestCase {

	@Test
	public void testRomanosTraduziveis() {
		ConverterParaRomano conversor = new ConverterParaRomano();
		
		assertEquals(new Integer(1), conversor.converter("i"));
		assertEquals(new Integer(9), conversor.converter("ix"));
		assertEquals(new Integer(30), conversor.converter("xxx"));
		assertEquals(new Integer(1280), conversor.converter("MCCLXXX"));
		assertEquals(new Integer(4974), conversor.converter("MMMMCMLXXIV"));
	}
	
	@Test
	public void testEntradasInvalidas() {
		ConverterParaRomano conversor = new ConverterParaRomano();

		assertEquals(null, conversor.converter("0"));
		assertEquals(null, conversor.converter("ABC"));
		assertEquals(null, conversor.converter(null));
		assertEquals(null, conversor.converter(""));
		
	}
	
	@Test
	public void testRomanosIntraduziveis() {
		ConverterParaRomano conversor = new ConverterParaRomano();
		assertEquals(null, conversor.converter("xiiii"));
		assertEquals(null, conversor.converter("xxxx"));
	}
	
}
