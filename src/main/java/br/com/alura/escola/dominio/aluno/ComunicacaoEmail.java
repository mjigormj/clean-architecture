package br.com.alura.escola.dominio.aluno;

public class ComunicacaoEmail {

	private String email;
	private String mensagem;

	public ComunicacaoEmail(String email, String mensagem) {
		if (email == null){
			throw new IllegalArgumentException("Email invalido!");
		}

		if (mensagem == null){
			throw new IllegalArgumentException("Mensagem invalida!");
		}

		this.email = email;
		this.mensagem = mensagem;
	}
	
	public String getEmail() {
		return email;
	}

	public String getMensagem() {
		return mensagem;
	}
	
}
