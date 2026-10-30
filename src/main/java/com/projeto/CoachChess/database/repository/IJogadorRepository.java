package com.projeto.CoachChess.database.repository;

import com.projeto.CoachChess.database.model.JogadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJogadorRepository extends JpaRepository<JogadorEntity, Long> {


}
