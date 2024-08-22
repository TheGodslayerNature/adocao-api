package com.adocao_api.controller;

import com.adocao_api.dto.PetRequestDto;
import com.adocao_api.dto.PetResponseDto;
import com.adocao_api.model.PetModel;
import com.adocao_api.service.PetService;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pet")
public class PetController {

    private PetService service;

    public PetController(PetService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity listarPets(){
        List<PetResponseDto> pets = service.listarPets().stream().map(PetResponseDto::new).toList();

        return ResponseEntity.ok(pets);
    }

    @PostMapping
    public ResponseEntity salvarPet(@RequestBody PetRequestDto petRequest){
        PetModel pet = new PetModel(petRequest);
        service.salvarPet(pet);
        PetResponseDto response = new PetResponseDto(pet);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity getPet(@PathVariable(value = "id") String id){
        PetModel pet = service.getPet(id);
        PetResponseDto response = new PetResponseDto(pet);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizarPet(@PathVariable(value = "id") String id, @RequestBody PetRequestDto request){
        PetModel pet = service.atualizarPet(id, request);
        PetResponseDto response = new PetResponseDto(pet);

        return ResponseEntity.ok().body(response);
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarPet(@PathVariable(value = "id") String id) {
        service.deletarPet(id);

        return ResponseEntity.ok().build();
    }
}
