package org.gmjm.streams.crypto.ciphers;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.gmjm.streams.crypto.Cipher;

public class AtbashCipher extends Cipher{
	
	Map<Integer,Integer> encryptMap;
	Map<Integer,Integer> decryptMap;
	
	public AtbashCipher(Map<Integer,Integer> encryptMap) {
		super("Substitution", "Atbash", "Each letter has a unique substitution.");
		this.encryptMap = encryptMap;
		
		decryptMap = new HashMap<Integer, Integer>();
		
		for(Entry<Integer,Integer> entry : encryptMap.entrySet())
		{
			decryptMap.put(entry.getValue(), entry.getKey());
		}
	}
	
	public AtbashCipher() {
		super("Substitution", "Atbash", "Each letter has a unique substitution.");
		
		encryptMap = new HashMap<Integer, Integer>();
		decryptMap = new HashMap<Integer, Integer>();
		
		List<Integer> characters = IntStream.range(1, 26).boxed().collect(Collectors.toList());
		Collections.shuffle(characters);
		
		for(int i = 0; i < characters.size(); i++)
		{
			encryptMap.put(characters.get(i), i);
			decryptMap.put(i,characters.get(i));
		}
		
	}

	@Override
	protected IntUnaryOperator protectedEncrypt() {
		return i -> {return encryptMap.get(i);};
	}

	@Override
	protected IntUnaryOperator protectedDecrypt() {
		return i -> {return decryptMap.get(i);};
	}
}
