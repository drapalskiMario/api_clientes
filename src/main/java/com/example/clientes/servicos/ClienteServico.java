package com.example.clientes.servicos;

import com.example.clientes.dto.ClienteDTO;
import com.example.clientes.entidades.Cliente;
import com.example.clientes.excecoes.ClienteNaoEncontradoExcecao;
import com.example.clientes.repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServico {

    @Autowired
    private ClienteRepositorio repositorio;

    public Cliente criarCliente(ClienteDTO clienteDTO) {
        var cliente = new Cliente();
        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());
        return repositorio.save(cliente);
    }

    public List<Cliente> listarClientes() {
        return repositorio.findAll();
    }

    public Cliente obterClientePorId(Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new ClienteNaoEncontradoExcecao(id));
    }

    public Cliente atualizarCliente(Long id, ClienteDTO clienteDTO) {
        var cliente = obterClientePorId(id);
        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());
        return repositorio.save(cliente);
    }

    public void deletarCliente(Long id) {
        var cliente = obterClientePorId(id);
        repositorio.delete(cliente);
    }
}
