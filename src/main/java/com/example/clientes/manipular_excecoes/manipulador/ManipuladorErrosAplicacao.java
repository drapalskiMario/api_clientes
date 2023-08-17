package com.example.clientes.manipular_excecoes.manipulador;

import com.example.clientes.excecoes.ClienteNaoEncontradoExcecao;
import com.example.clientes.manipular_excecoes.erros.RespostaErro;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ManipuladorErrosAplicacao {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RespostaErro manipularExcecaoValidacao(MethodArgumentNotValidException excecao) {
        var bindingResult = excecao.getBindingResult();
        return new RespostaErro(bindingResult);
    }

    @ExceptionHandler(ClienteNaoEncontradoExcecao.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public RespostaErro manipularExcecaoClienteNaoEncontrado(ClienteNaoEncontradoExcecao excecao) {
        return new RespostaErro(excecao.getMessage());
    }
}
