package com.DanteQQ.JumpScareAPI.controller;

import com.DanteQQ.JumpScareAPI.model.JumpScareTime;
import com.DanteQQ.JumpScareAPI.repository.JumpScareTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<List<JumpScareTime>> getAllJumpScareTimes() {
        List<JumpScareTime> jumpScareTimes = jumpScareTimeRepository.findAll();
        return ResponseEntity.ok(jumpScareTimes);
    }

    @GetMapping("/jumpScareTimes/{id}")
    public ResponseEntity<JumpScareTime> getJumpScareTimeById(@PathVariable int id) {
        Optional<JumpScareTime> jumpScareTime = jumpScareTimeRepository.findById(id);
        if (jumpScareTime.isPresent()) {
            return ResponseEntity.ok(jumpScareTime.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/jumpScareTimes/{id}")
    public ResponseEntity<Void> deleteJumpScareTimeById(@PathVariable Long id) {
        jumpScareTimeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
