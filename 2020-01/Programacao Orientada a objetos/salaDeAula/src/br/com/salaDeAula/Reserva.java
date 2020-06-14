package br.com.salaDeAula;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class Reserva {
    Hora horaInicio;
    Hora horaTermino;
    Funcionario funcionario;
    Professor professor;
    Turma turma;
    Sala sala;
    Date dataInicio;


    public Reserva(String data,Hora horaInicio,Hora horaTermino, Funcionario funcionario, Professor professor, Turma turma, Sala sala) throws ParseException{
        this.dataInicio = convertData(data);
        this.horaInicio = horaInicio;
        this.horaTermino = horaTermino;
        this.funcionario = funcionario;
        this.professor = professor;
        this.turma = turma;
        this.sala = sala;
        this.validarReserva();
    }
    public void imprimeData(){
        System.out.println(dataInicio);
    }

    public Date convertData(String data) throws ParseException {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
       return date;
    }

    public void validarReserva() throws IllegalStateException {
        if(this.turma.quantidadeAlunosMatriculados > this.sala.calcularCapacidade()){
            throw new IllegalStateException("A reserva não pode ser concluída. vagas insuficientes na sala.");
        }
    }
}
