package application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import application.model.Categoria;
import application.repository.CategoriaRepository;
import application.service.record.CategoriaDTO;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepo;

    public List<CategoriaDTO> findAll() {
        return categoriaRepo.findAll().stream().map(CategoriaDTO::new).toList();
    }

    public CategoriaDTO insert(CategoriaDTO categoria) {
        Categoria nova = categoriaRepo.save(new Categoria(categoria));
        return new CategoriaDTO(nova);
    }

    public CategoriaDTO findById(long id) {
        Optional<Categoria> resultado = categoriaRepo.findById(id);
        if(resultado.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada");
        }
        return new CategoriaDTO(resultado.get());
    }

    public void deleteById(long id) {
        if(!categoriaRepo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Categoria Não Encontrada"
            );
        }
       categoriaRepo.deleteById(id);
    }

    public CategoriaDTO update(long id, CategoriaDTO categoria) {
        if(!categoriaRepo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Categoria Não Encontrada"
            );
        }
        Categoria novo = new Categoria(categoria);
        novo.setId(id);
        Categoria atualizado = categoriaRepo.save(new Categoria(categoria));
        return new CategoriaDTO(atualizado);
    }
    
}

