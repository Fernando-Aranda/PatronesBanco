package cl.ucn.service;

import cl.ucn.bean.Cliente;
import cl.ucn.persistence.StorageCliente;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;

import java.io.Serializable;

@Named
public class ClienteService  {

    @Inject
    private StorageCliente storageCliente;

    @Transactional
    public void agregarCliente(Cliente cliente) {
        storageCliente.guardarCliente(cliente);
    }
}

