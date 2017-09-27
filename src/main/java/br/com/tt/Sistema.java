package br.com.tt;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.tt.model.Cliente;
import br.com.tt.model.Reserva;

public class Sistema {
	
	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("pu_tt").createEntityManager();
		
		Cliente cliente = new Cliente();
		Reserva reserva = new Reserva();
		reserva.addCliente(cliente);
		cliente.setNome("Lais");
		cliente.setCpf("12312312334");
		reserva.setData(Calendar.getInstance());
		reserva.setDias(4);
		reserva.setValor(234.80d);
		
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		em.clear();
		em.close();
		
		System.exit(0);
	}
	
}
