package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import application.repository.CategoriaRepository;
import application.service.CategoriaService;
import application.service.record.CategoriaDTO;
import application.model.Categoria;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    @GetMapping
    public Iterable<CategoriaDTO> findAll() {
        return categoriaService.findAll();
    
    }

    @GetMapping("/{id}")
    public CategoriaDTO findOne(@PathVariable long id) {
        return categoriaService.findById(id);
    }

    @PostMapping
    public CategoriaDTO insert(@RequestBody CategoriaDTO categoria) {
        return categoriaService.insert(categoria);
    }
    
    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable long id) {
        categoriaService.deleteById(id);
    }

    @PutMapping("/{id}")
    public CategoriaDTO update(@PathVariable long id, @RequestBody CategoriaDTO categoria) {
        return categoriaService.update(id, categoria);
    }
}
