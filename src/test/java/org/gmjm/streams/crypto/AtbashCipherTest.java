package org.gmjm.streams.crypto;

import org.gmjm.streams.crypto.Cipher;
import org.gmjm.streams.crypto.ciphers.AtbashCipher;
import org.junit.Test;

public class AtbashCipherTest {
	@Test
	public void testAtbash()
	{
		Cipher cipher = new AtbashCipher();
		
		String input = "Testing input into cipher";
		
		String encrypted = cipher.encrypt(input);
		
		System.out.println("Encrypted: " + encrypted);
		System.out.println("Decrypted: " + cipher.decrypt(encrypted));
		
	}
}
