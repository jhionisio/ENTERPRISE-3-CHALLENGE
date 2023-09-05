package com.feedback.plusSoft.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feedback.plusSoft.models.Feedback;
import com.feedback.plusSoft.services.FeedbackService;

import java.util.List;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping
    @ApiOperation("Cria um novo feedback")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Feedback cadastrado com sucesso"),
            @ApiResponse(code = 400, message = "Erro na validação dos dados da requisição")
    })
    public ResponseEntity<Void> create(@RequestBody Feedback feedback) {
        feedbackService.create(feedback);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("{id}")
    @ApiOperation("Retorna os detalhes de um feedback")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Feedback encontrado com sucesso"),
            @ApiResponse(code = 404, message = "Feedback não encontrado")
    })
    public ResponseEntity<Feedback> getById(@PathVariable Long id) {
        Feedback feedback = feedbackService.findById(id);
        if (feedback != null) {
            return ResponseEntity.ok(feedback);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Feedback>> getAll() {
        List<Feedback> feedbacks = feedbackService.findAll();
        return ResponseEntity.ok(feedbacks);
    }

    @PutMapping("{id}")
    @ApiOperation("Atualiza um feedback")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Feedback atualizado com sucesso"),
            @ApiResponse(code = 400, message = "Erro na validação dos dados da requisição"),
            @ApiResponse(code = 404, message = "Feedback não encontrado")
    })
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Feedback feedback) {
        Feedback existingFeedback = feedbackService.findById(id);
        if (existingFeedback != null) {
            feedbackService.update(id, feedback);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    @ApiOperation("Exclui um feedback")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Feedback excluído com sucesso"),
            @ApiResponse(code = 404, message = "Feedback não encontrado")
    })
    public ResponseEntity<Void> destroy(@PathVariable Long id) {
        Feedback existingFeedback = feedbackService.findById(id);
        if (existingFeedback != null) {
            feedbackService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
