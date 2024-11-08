package cl.ucn.persistence;
import cl.ucn.bean.Cuenta;

public interface IStorageCuenta {
    Cuenta getCuenta(String cuenta);
    void guardarCuenta(Cuenta cuenta);
    void eliminarCuenta(String cuenta);
}
