package br.com.tt.model;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
	private String nome;
	private String cpf;
	@ManyToMany(mappedBy = "clientes", cascade = ALL)
	private List<Reserva> reservas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public void addReserva(Reserva reserva) {
		if (reserva != null) {
			if (reservas == null) {
				reservas = new ArrayList<>();
			}
			reservas.add(reserva);
		}
	}

}
