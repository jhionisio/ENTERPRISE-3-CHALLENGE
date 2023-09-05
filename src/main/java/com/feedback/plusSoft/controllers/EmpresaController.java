package com.feedback.plusSoft.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.persistence.EntityManager;
import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.feedback.plusSoft.models.Empresa;
import com.feedback.plusSoft.models.Usuario;
import com.feedback.plusSoft.services.EmpresaService;
import com.feedback.plusSoft.services.UsuarioService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    @ApiOperation("Cria uma nova empresa")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Empresa cadastrada com sucesso"),
            @ApiResponse(code = 400, message = "Erro na validação dos dados da requisição")
    })
    public ResponseEntity<Void> create(@RequestBody Empresa empresa) {
        empresaService.create(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("{id}")
    @ApiOperation("Retorna os detalhes de uma empresa")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Empresa encontrada com sucesso"),
            @ApiResponse(code = 404, message = "Empresa não encontrada")
    })
    public ResponseEntity<Empresa> getById(@PathVariable Long id) {
        Empresa empresa = empresaService.findById(id);
        if (empresa != null) {
            return ResponseEntity.ok(empresa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Empresa>> getAll() {
        List<Empresa> empresas = empresaService.findAll();
        return ResponseEntity.ok(empresas);
    }

    @PutMapping("{id}")
    @ApiOperation("Atualiza uma empresa")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Empresa atualizada com sucesso"),
            @ApiResponse(code = 400, message = "Erro na validação dos dados da requisição"),
            @ApiResponse(code = 404, message = "Empresa não encontrada")
    })
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Empresa empresa) {
        Empresa existingEmpresa = empresaService.findById(id);
        if (existingEmpresa != null) {
            empresaService.update(id, empresa);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    @ApiOperation("Exclui uma empresa")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Empresa excluída com sucesso"),
            @ApiResponse(code = 404, message = "Empresa não encontrada")
    })
    public ResponseEntity<Void> destroy(@PathVariable Long id) {
        Empresa existingEmpresa = empresaService.findById(id);
        if (existingEmpresa != null) {
            empresaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
