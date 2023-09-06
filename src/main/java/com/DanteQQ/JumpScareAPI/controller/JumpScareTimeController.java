package com.DanteQQ.JumpScareAPI.controller;

import com.DanteQQ.JumpScareAPI.model.JumpScareTime;
import com.DanteQQ.JumpScareAPI.repository.JumpScareTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JumpScareTimeController {
    @Autowired
    JumpScareTimeRepository jumpScareTimeRepository;
    @PostMapping("/jumpScareTimes")
    public ResponseEntity<JumpScareTime> addJumpScareTime(@RequestBody JumpScareTime jumpScareTime) {
        JumpScareTime savedjumpScareTime = jumpScareTimeRepository.save(jumpScareTime);
        return new ResponseEntity<>(savedjumpScareTime, HttpStatus.CREATED);
    }
}
