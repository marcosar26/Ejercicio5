package es.marcosar.ejercicio5.service;

import es.marcosar.ejercicio5.dto.ClienteDto;
import es.marcosar.ejercicio5.model.Cliente;
import es.marcosar.ejercicio5.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    private ClienteDto mapToDto(Cliente cliente) {
        return new ClienteDto(cliente.getNombre(), cliente.getCorreo());
    }

    public List<ClienteDto> findAll() {
        return StreamSupport.stream(clienteRepository.findAll().spliterator(), false)
                .map(this::mapToDto)
                .toList();
    }

    public ClienteDto add(Cliente cliente) {
        return mapToDto(clienteRepository.save(cliente));
    }

    public ClienteDto update(Long id, Cliente cliente) {
        Cliente c = clienteRepository.findById(id).orElseThrow();

        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
        c.setCorreo(cliente.getCorreo());
        c.setTelefono(cliente.getTelefono());
        c.setPais_origen(cliente.getPais_origen());
        c.setReservas(cliente.getReservas());

        return mapToDto(clienteRepository.save(c));
    }

    public void delete(Long id) {
        Cliente c = clienteRepository.findById(id).orElseThrow();
        clienteRepository.delete(c);
    }
}
