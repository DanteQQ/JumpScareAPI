package com.DanteQQ.JumpScareAPI.repository;

import com.DanteQQ.JumpScareAPI.model.JumpScareTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JumpScareTimeRepository extends JpaRepository<JumpScareTime, Integer> {
    void deleteById(Long id);

    List<JumpScareTime> findByMovieId(int movieId);
}
