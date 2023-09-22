package br.com.alura.escola.aplicacao.indicacao;

import br.com.alura.escola.dominio.aluno.ComunicacaoEmail;

public interface EnviarEmailIndicacao {

    void enviarPara(ComunicacaoEmail comunicacao);
}
