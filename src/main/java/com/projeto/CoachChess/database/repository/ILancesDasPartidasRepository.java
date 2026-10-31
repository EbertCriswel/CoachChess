package com.projeto.CoachChess.database.repository;

import com.projeto.CoachChess.database.model.LancesDasPartidasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILancesDasPartidasRepository extends JpaRepository<LancesDasPartidasEntity, Long> {

    List<LancesDasPartidasEntity> findByPartidaIdOrderByNumeroDoLanceAsc(Long partidaId);
}