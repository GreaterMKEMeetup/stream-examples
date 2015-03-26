package org.gmjm.streams.crypto;

import org.gmjm.streams.crypto.Cipher;
import org.gmjm.streams.crypto.CrackingUtils;
import org.gmjm.streams.crypto.ciphers.CaesarCipher;
import org.junit.Test;

public class CaesarCipherTest {
	
	
	@Test
	public void testRot13()
	{
		Cipher cipher = new CaesarCipher(5);
		
		String input = "Testing input into cipher";
		
		String encrypted = cipher.encrypt(input);
		
		System.out.println("Encrypted: " + encrypted);
		System.out.println("Decrypted: " + cipher.decrypt(encrypted));
		
		CrackingUtils.calculateAndPrintFrequencies(input);
	}

}
