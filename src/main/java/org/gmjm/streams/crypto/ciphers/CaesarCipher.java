package org.gmjm.streams.crypto.ciphers;

import java.util.function.IntUnaryOperator;

import org.gmjm.streams.crypto.Cipher;

public class CaesarCipher extends Cipher{

	private final int rot;
	
	public CaesarCipher(int rot) {
		super("Substitution", "Caesar Cipher", "All values are shifted by a constant amount.");
		this.rot = rot;
	}

	@Override
	protected IntUnaryOperator protectedEncrypt() {
		return c -> (c + rot) % 26;
	}

	@Override
	protected IntUnaryOperator protectedDecrypt() {
		return 
			c -> {
				int result = (c - rot);
				return result < 0 ? result + 26 : result;
			};
	}

}
