package com.curso.repositories;

import com.curso.domains.GrupoLivro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoLivroRepository extends JpaRepository<GrupoLivro,Integer> {
}
