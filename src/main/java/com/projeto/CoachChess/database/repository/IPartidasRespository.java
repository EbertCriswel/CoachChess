package com.projeto.CoachChess.database.repository;


import com.projeto.CoachChess.database.model.PartidasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface IPartidasRespository extends JpaRepository<PartidasEntity, Long> {


}
