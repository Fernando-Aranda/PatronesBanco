package cl.ucn.persistence;

import cl.ucn.bean.Cliente;

public interface IStorageCliente {

	Cliente getCliente(int rut);
	void guardarCliente(Cliente cliente);
	void eliminarCliente(int rut);
}
