package cl.ucn.service;

import cl.ucn.bean.Cuenta;
import cl.ucn.persistence.StorageCuenta;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;

@Named
public class CuentaService {

    @Inject
    private StorageCuenta storageCuenta;

    @Transactional
    public void agregarCuenta(Cuenta cuenta) {
        storageCuenta.guardarCuenta(cuenta);
    }
}
