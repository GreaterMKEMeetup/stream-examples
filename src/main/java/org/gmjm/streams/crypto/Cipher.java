package org.gmjm.streams.crypto;

import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public abstract class Cipher {
	private String cipherType;
	private String cipherName;
	private String cipherDescription;
	
	
	
	public Cipher(String cipherType, String cipherName, String cipherDescription) {
		this.cipherType = cipherType;
		this.cipherName = cipherName;
		this.cipherDescription = cipherDescription;
	}
	public String getCipherType() {
		return cipherType;
	}
	public String getCipherName() {
		return cipherName;
	}
	public String getCipherDescription() {
		return cipherDescription;
	}
	
	private static final IntUnaryOperator TO_LOWER_FUNCTION = c -> 
		{
			if(c >= 65 && c <= 90)
				return c + 32;
			return c;
		};
		
	private static final IntUnaryOperator MAP_TO_0_26 = c -> c - 97;
	private static final IntUnaryOperator MAP_FROM_0_26 = c -> c + 97;
	
	public String encrypt(String input)
	{
		return toString(runCipher(input.chars(),protectedEncrypt()));
	}
	
	public String encrypt(IntStream intStream)
	{
		return toString(runCipher(intStream, protectedEncrypt()));
	}
	
	public IntStream encryptToStream(IntStream intStream)
	{
		return runCipher(intStream, protectedEncrypt());
	}
	
	protected abstract IntUnaryOperator protectedEncrypt();
	
	public String decrypt(String input)
	{
		return toString(runCipher(input.chars(),protectedDecrypt()));
	}
	
	public String decrypt(IntStream intStream)
	{
		return toString(runCipher(intStream, protectedDecrypt()));
	}
	
	public IntStream decryptToStream(IntStream intStream)
	{
		return runCipher(intStream, protectedDecrypt());
	}
	
	protected abstract IntUnaryOperator protectedDecrypt();
	
	private IntStream runCipher(IntStream intStream, IntUnaryOperator cipherFunction)
	{
		return intStream
				.map(TO_LOWER_FUNCTION)
				.map(c -> {
								if(c >= 97 && c <= 122) 
									return MAP_FROM_0_26.applyAsInt(cipherFunction.applyAsInt(MAP_TO_0_26.applyAsInt(c)));
								return c;
							}
				);
	}
	
	private String toString(IntStream intStream)
	{
		return intStream
				.collect(StringBuilder::new,StringBuilder::appendCodePoint, StringBuilder::append)
		        .toString();
	}
	
	@Override
	public String toString()
	{
		return String.format("(%s) - %s",cipherType,cipherName);
	}
}
