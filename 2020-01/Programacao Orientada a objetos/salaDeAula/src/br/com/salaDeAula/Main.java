package br.com.salaDeAula;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
        Curso c1= new Curso(1,"ADS");
        Funcionario f1= new Funcionario(1,"Oracio","(31) 99999-8888","Oracio@mail");
        Professor p1=new Professor(2,"Girafales","(31) 99999-7777","Girafalaes@mail","Professor",c1);
        Turma t1 = new Turma(c1, "NOITE", "1", 20);
        Sala s1 = new Sala(1,30,10, 10,false,false);
        Reserva r1 = new Reserva(
                "05/11/1995",
                new Hora(10,0,0),
                new Hora(11,23,43),
                f1,
                p1,
                t1,
                s1);
        Laboratorio laboratorio = new Laboratorio(1, 10, 10, true, true, 10, 2, 14, 200, 100, "Windows");
        Reserva r2 = new Reserva(
                "05/11/1995",
                new Hora(10,0,0),
                new Hora(11,23,43),
                f1,
                p1,
                t1,
                laboratorio);
    }
}
