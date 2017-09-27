package br.com.tt.model;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.TemporalType.DATE;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;

@Entity
public class Reserva {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
	private Integer dias;
	private Double valor;
	@Temporal(DATE)
	private Calendar data;
	@ManyToMany(cascade = ALL)
// @formatter:off
	@JoinTable(
			name = "relacao_cliente_reserva",
			joinColumns= {@JoinColumn(name="reserva_key")},
			inverseJoinColumns= {@JoinColumn(name = "cliente_key")}
	)
// @formatter:on
	private List<Cliente> clientes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDias() {
		return dias;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public void addCliente(Cliente cliente) {
		if (cliente != null) {
			if (clientes == null) {
				clientes = new ArrayList<>();
			}
			clientes.add(cliente);
			cliente.addReserva(this);
		}
	}

}
