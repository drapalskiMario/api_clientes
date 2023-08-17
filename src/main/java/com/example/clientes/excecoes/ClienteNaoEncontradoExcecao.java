package com.example.clientes.excecoes;

public class ClienteNaoEncontradoExcecao extends RuntimeException{
    public ClienteNaoEncontradoExcecao(Long id) {
        super("Cliente não encontrado com o ID: " + id);
    }
}
