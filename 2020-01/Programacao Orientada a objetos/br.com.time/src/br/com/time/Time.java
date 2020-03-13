package br.com.time;

public class Time {
	private int hora, minuto, segundo;
	public Time() {
		this.setHora(this.setMinuto(this.setSegundo(0)));
	}
	
	public Time(int hora) {
		this.setHora(hora);
		this.setMinuto(this.setSegundo(0));
	}
	
	public Time(int hora, int minuto) {
		this.setHora(hora);
		this.setMinuto(minuto);
		this.setSegundo(0);
	}
	
	public Time(int hora, int minuto, int segundo) {
		this.setTime(hora, minuto, segundo);
	}

	public int getHora() {
		return hora;
	}

	public int setHora(int hora) {
		this.hora = hora >= 0 && hora <= 23 ? hora : 0;
		return hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public int setMinuto(int minuto) {
		this.minuto = minuto >= 0 && minuto <= 60 ? minuto : 0;
		return minuto;
	}

	public int getSegundo() {
		return segundo;
	}

	public int setSegundo(int segundo) {
		this.segundo = segundo >= 0 && segundo <= 60 ? segundo : 0;
		return segundo;
	}
	
	public Time setTime(int hora, int minuto, int segundo) {
		this.setHora(hora);
		this.setMinuto(minuto);
		this.setSegundo(segundo);
		return this;
	}
	
	public String exibe() {
		return String.format("%02d:%02d:%02d",
				this.getHora(),
				this.getMinuto(),
				this.getSegundo());
	}
}
