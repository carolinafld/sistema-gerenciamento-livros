package com.gerenciamento.livros.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LivroController {

    @GetMapping
    public String index() {
        return "index"; // Mapeia para src/main/resources/templates/index.html
    }

    @GetMapping("/livros")
    public String listarLivros() {
        return "listar-livros"; // Mapeia para src/main/resources/templates/listar-livros.html
    }

    @GetMapping("/livros/adicionar")
    public String adicionarLivro() {
        return "adicionar-livro"; // Mapeia para src/main/resources/templates/adicionar-livro.html
    }
}


