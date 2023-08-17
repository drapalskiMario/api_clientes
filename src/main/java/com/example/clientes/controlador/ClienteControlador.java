package com.example.clientes.controlador;

import com.example.clientes.dto.ClienteDTO;
import com.example.clientes.entidades.Cliente;
import com.example.clientes.servicos.ClienteServico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteControlador {

    @Autowired
    private ClienteServico servico;

    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody @Valid ClienteDTO clienteDTO) {
        var cliente = servico.criarCliente(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        var clientes = servico.listarClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obterClientePorId(@PathVariable Long id) {
        var cliente = servico.obterClientePorId(id);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody @Valid ClienteDTO clienteDTO) {
        var cliente = servico.atualizarCliente(id, clienteDTO);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        servico.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }
}
