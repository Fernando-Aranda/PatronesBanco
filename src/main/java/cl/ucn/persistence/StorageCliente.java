package cl.ucn.persistence;

import cl.ucn.bean.Cliente;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@LocalBean
@Stateless
public class StorageCliente implements IStorageCliente{

	@PersistenceContext(unitName = "bancoappPersistenceUnit")
	protected EntityManager em;

	@Override
	public Cliente getCliente(int rut) {
		// TODO Auto-generated method stub
		Query q = em.createQuery("SELECT p FROM Cliente p WHERE p.rut = :rut");
		q.setParameter("rut", rut);
        return (Cliente) q.getSingleResult();
	}

	@Override
	public void guardarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		em.persist(cliente);
		em.flush();
	}

	@Override
	public void eliminarCliente(int rut) {
		// TODO Auto-generated method stub

	}

}
