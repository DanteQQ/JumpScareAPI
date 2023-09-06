package com.DanteQQ.JumpScareAPI.repository;

import com.DanteQQ.JumpScareAPI.model.JumpScareTime;
import com.DanteQQ.JumpScareAPI.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JumpScareTimeRepository extends JpaRepository<JumpScareTime, Integer> {

}
