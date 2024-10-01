package application.service.record;

import application.model.Categoria;

public record CategoriaDTO(long id, String nome) {
    public CategoriaDTO(Categoria categoria){
        this(categoria.getId(), categoria.getNome());
    }   
}
