package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.repository.CategoriaRepository;
import application.model.Categoria;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    CategoriaRepository categoriaRepo;

    @GetMapping
    public Iterable<Categoria> findAll() {
        return categoriaRepo.findAll();
    
    }

    @PostMapping
    public Categoria insert(@RequestBody Categoria categoria) {
        return categoriaRepo.save(categoria);
    }
}
