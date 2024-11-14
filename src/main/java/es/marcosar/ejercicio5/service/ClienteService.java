package es.marcosar.ejercicio5.service;

import es.marcosar.ejercicio5.model.Cliente;
import es.marcosar.ejercicio5.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return StreamSupport.stream(clienteRepository.findAll().spliterator(), false).toList();
    }

    public Cliente add(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente update(Long id, Cliente cliente) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);

        if (clienteOptional.isEmpty()) {
            throw new NoSuchElementException("No existe el cliente con id " + id);
        }

        Cliente c = clienteOptional.get();

        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
        c.setCorreo(cliente.getCorreo());
        c.setTelefono(cliente.getTelefono());
        c.setPais_origen(cliente.getPais_origen());
        c.setReservas(cliente.getReservas());

        return clienteRepository.save(c);
    }

    public void delete(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);

        if (clienteOptional.isEmpty()) {
            throw new NoSuchElementException("No existe el cliente con id " + id);
        }

        clienteRepository.deleteById(id);
    }
}
