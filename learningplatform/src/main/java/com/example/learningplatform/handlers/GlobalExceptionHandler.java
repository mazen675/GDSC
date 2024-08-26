package com.example.learningplatform.handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalException(Exception e){
        e.printStackTrace();
        Map<String, Object> res=new HashMap<>();
        res.put("ok",false);
        res.put("Error",e.getMessage());
        return ResponseEntity.badRequest().body(res);
    }
}
