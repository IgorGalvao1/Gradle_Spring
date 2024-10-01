package application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.model.Categoria;
import application.repository.CategoriaRepository;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepo;

    public Iterable<Categoria> findAll() {
        return categoriaRepo.findAll();
    }

    public Categoria insert(Categoria categoria) {
        return categoriaRepo.save(categoria);
    }
}
