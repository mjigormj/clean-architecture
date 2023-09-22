package br.com.alura.escola;

import br.com.alura.escola.aplicacao.aluno.matricular.MaticularAlunoDto;
import br.com.alura.escola.aplicacao.aluno.matricular.MatricularAluno;
import br.com.alura.escola.infra.aluno.RepositorioDeAlunosEmMemoria;

public class MatricularAlunoPorLinhaDeComando {
    public static void main(String[] args) {
        String nome = "Marcos 9 Caldas";
        String cpf = "123.456.789-00";
        String email = "email@gmail.com";

        MatricularAluno matricular = new MatricularAluno(new RepositorioDeAlunosEmMemoria());
        matricular.executa(
                new MaticularAlunoDto(nome,
                        cpf,
                        email));

//        enviarEmailIndicacao.enviarPara(new ComunicacaoEmail(aluno.getEmail(),
//                "Sr " + aluno.getNome() + ", as aulas se iniciarão neste domingo (24/09/2023) " +
//                        "\n É de extrema importancia que o senhor traga seu proprio copo!"));


    }

}
