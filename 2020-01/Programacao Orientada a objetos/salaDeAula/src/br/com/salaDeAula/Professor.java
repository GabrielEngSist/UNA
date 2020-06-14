package br.com.salaDeAula;

public class Professor extends Funcionario {

    String nivelCargo;
    Curso curso;

    public Professor(int matricula, String nome, String telefone, String email, String nivelCargo, Curso curso) {
        super(matricula, nome, telefone, email);
        this.nivelCargo=nivelCargo;
        this.curso=curso;
    }
}
