package br.com.fatec.sistema.bibliotecario.utils;

import java.util.Base64;

public class Encode {

	public static String codificarSenha(String senha) {
		byte[] senhaBytes = senha.getBytes();
		byte[] senhaCodificadaBytes = Base64.getEncoder().encode(senhaBytes);
		return new String(senhaCodificadaBytes);
	}

}
