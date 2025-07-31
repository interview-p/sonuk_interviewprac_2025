package com.skt.SpringAi.controller;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class rsaKeygenerator {

	public static void main(String[] args) throws NoSuchAlgorithmException {

		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
		keyGen.initialize(2048);
		KeyPair keyPair = keyGen.generateKeyPair();

		PublicKey publicKey = keyPair.getPublic();
		System.out.println("public key = "+publicKey);
		PrivateKey privateKey = keyPair.getPrivate();
		System.out.println("private key = "+privateKey);
		
	}

}
