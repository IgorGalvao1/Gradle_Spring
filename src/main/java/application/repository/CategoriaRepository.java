package application.repository;

import org.springframework.data.repository.CrudRepository;

import application.model.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
    public Categoria findByNome(String nome);
}
