package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.repository.CategoriaRepository;
import application.service.CategoriaService;
import application.model.Categoria;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    @GetMapping
    public Iterable<Categoria> findAll() {
        return categoriaService.findAll();
    
    }

    @PostMapping
    public Categoria insert(@RequestBody Categoria categoria) {
        return categoriaService.insert(categoria);
    }
}
