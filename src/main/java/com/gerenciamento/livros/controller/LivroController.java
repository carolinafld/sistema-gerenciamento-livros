package com.gerenciamento.livros.controller;

import com.gerenciamento.livros.Livro;
import com.gerenciamento.livros.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class LivroController {
    
    @Autowired
    private LivroRepository livroRepository; // Injeção do repositório

    @GetMapping
    public String index() {
        return "index"; // Mapeia para src/main/resources/templates/index.html
    }

    @GetMapping("/livros")
    public String listarLivros(Model model) {
        try {
            model.addAttribute("livros", livroRepository.findAll()); // Passa a lista de livros para o modelo
        } catch (Exception e) {
            e.printStackTrace(); // Log do erro
            return "error"; // Mapeia para uma página de erro genérica
        }
        return "listar-livros"; // Mapeia para src/main/resources/templates/listar-livros.html
    }

    @GetMapping("/livros/adicionar")
    public String adicionarLivroForm(Model model) {
        model.addAttribute("livro", new Livro());
        return "adicionar-livro"; // Mapeia para src/main/resources/templates/adicionar-livro.html
    }
    
    @PostMapping("/livros/adicionar")
    public String adicionarLivro(Livro livro) {
        // Salva o livro no banco de dados
        livroRepository.save(livro);
        return "redirect:/livros"; // Redireciona para a lista de livros
    }
}


