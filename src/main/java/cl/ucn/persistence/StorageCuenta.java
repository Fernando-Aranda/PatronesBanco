package cl.ucn.persistence;
import cl.ucn.bean.Cliente;
import cl.ucn.bean.Cuenta;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@LocalBean
@Stateless
public class StorageCuenta implements IStorageCuenta {

    @PersistenceContext(unitName = "bancoappPersistenceUnit")
    protected EntityManager em;

    @Override
    public Cuenta getCuenta(String cuenta) {
        // TODO Auto-generated method stub
        Query q = em.createQuery("SELECT p FROM Cuenta p WHERE p.id = :id");
        q.setParameter("id", cuenta);
        return (Cuenta) q.getSingleResult();
    }

    @Override
    public void guardarCuenta(Cuenta cuenta) {
        em.persist(cuenta);
        em.flush();
    }

    @Override
    public void eliminarCuenta(String cuenta) {

    }
}
