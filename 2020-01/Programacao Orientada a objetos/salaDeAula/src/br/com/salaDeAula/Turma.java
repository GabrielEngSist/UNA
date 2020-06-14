package br.com.salaDeAula;

public class Turma {
    Curso curso;
    String turno;
    String periodo;
    int quantidadeAlunosMatriculados;

    public Turma(Curso curso, String turno, String periodo, int quantidadeAlunosMatriculados) {
        this.curso = curso;
        this.turno = turno;
        this.periodo = periodo;
        this.quantidadeAlunosMatriculados = quantidadeAlunosMatriculados;
    }
}
