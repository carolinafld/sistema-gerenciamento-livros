package com.gerenciamento.livros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping("/livros")
    public String listarLivros(Model model) {
        List<Livro> livros = livroRepository.findAll();
        model.addAttribute("livros", livros);
        return "livros";
    }

    @GetMapping("/livros/novo")
    public String novoLivroForm(Model model) {
        model.addAttribute("livro", new Livro());
        return "livro-form";
    }

    @PostMapping("/livros")
    public String salvarLivro(@ModelAttribute Livro livro) {
        livroRepository.save(livro);
        return "redirect:/livros";
    }

    @GetMapping("/livros/{id}/editar")
    public String editarLivroForm(@PathVariable Long id, Model model) {
        Livro livro = livroRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Livro inválido"));
        model.addAttribute("livro", livro);
        return "livro-form";
    }

    @PostMapping("/livros/{id}")
    public String atualizarLivro(@PathVariable Long id, @ModelAttribute Livro livroAtualizado) {
        Livro livro = livroRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Livro inválido"));
        livro.setTitulo(livroAtualizado.getTitulo());
        livro.setAutor(livroAtualizado.getAutor());
        livro.setIsbn(livroAtualizado.getIsbn());
        livroRepository.save(livro);
        return "redirect:/livros";
    }

    @GetMapping("/livros/{id}/deletar")
    public String deletarLivro(@PathVariable Long id) {
        Livro livro = livroRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Livro inválido"));
        livroRepository.delete(livro);
        return "redirect:/livros";
    }
}
