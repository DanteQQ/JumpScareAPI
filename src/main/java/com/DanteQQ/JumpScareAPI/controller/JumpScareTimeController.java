package com.DanteQQ.JumpScareAPI.controller;

import com.DanteQQ.JumpScareAPI.model.JumpScareTime;
import com.DanteQQ.JumpScareAPI.repository.JumpScareTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JumpScareTimeController {
    @Autowired
    JumpScareTimeRepository jumpScareTimeRepository;

    @PostMapping("/jumpScareTimes")
    public ResponseEntity<JumpScareTime> addJumpScareTime(@RequestBody JumpScareTime jumpScareTime) {
        JumpScareTime savedjumpScareTime = jumpScareTimeRepository.save(jumpScareTime);
        return ResponseEntity.ok(savedjumpScareTime);
    }

    @GetMapping("/jumpScareTimes")
    public List<JumpScareTime> findByMovieId(@RequestParam(value = "movieId") int movieId) {
        return jumpScareTimeRepository.findByMovieId(movieId);
    }

    @DeleteMapping("/jumpScareTimes/{id}")
    @Transactional
    public ResponseEntity<Void> deleteJumpScareTimeById(@PathVariable Long id) {
        jumpScareTimeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
