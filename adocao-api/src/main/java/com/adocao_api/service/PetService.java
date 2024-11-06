package com.adocao_api.service;

import com.adocao_api.dto.PetRequestDto;
import com.adocao_api.exception.PetNotFoundException;
import com.adocao_api.mapper.PetMapper;
import com.adocao_api.model.PetModel;
import com.adocao_api.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    private final PetRepository repository;
    private final PetMapper mapper;
    public PetService(PetRepository repository, PetMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public PetModel salvarPet(PetRequestDto pet){
        return repository.save(mapper.toPet(pet));
    }

    public List<PetModel> listarPets(){
        return repository.findAll();
    }

    public PetModel getPet(String id){
        return repository.findById(id).orElseThrow(() -> new PetNotFoundException("Pet não encontrado"));
    }

    public PetModel atualizarPet(String id, PetRequestDto request){
        getPet(id);
        PetModel petModel = mapper.toPet(id,request);
        return repository.save(petModel);
    }

    public void deletarPet(String id) {
        repository.delete(getPet(id));
    }
}
