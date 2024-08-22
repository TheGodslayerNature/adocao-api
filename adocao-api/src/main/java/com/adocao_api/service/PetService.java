package com.adocao_api.service;

import com.adocao_api.dto.PetRequestDto;
import com.adocao_api.model.PetModel;
import com.adocao_api.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    private final PetRepository repository;

    public PetService(PetRepository repository) {
        this.repository = repository;
    }

    public PetModel salvarPet(PetModel pet){

        if (pet.getId() == null)
                return repository.save(pet);
        else {
            throw new RuntimeException("Esse Pet já existe");
        }
    }

    public List<PetModel> listarPets(){
        return repository.findAll();
    }

    public PetModel getPet(String id){
        if (repository.findById(id).isPresent())
            return repository.findById(id).get();
        throw new RuntimeException("Pet não encontrado");
    }

    public PetModel atualizarPet(String id, PetRequestDto request){
        if (repository.findById(id).isPresent()){
            PetModel petModel = new PetModel(id, request.nome(), request.raca(), request.imagem());
            return repository.save(petModel);
        }
        throw new RuntimeException("Pet não encontrado");
    }

    public void deletarPet(String id) {
        Optional<PetModel> pet = repository.findById(id);

        if (pet.isPresent()) {
            repository.delete(pet.get());
        }
        else {
            throw new RuntimeException("Pet não encontrado");
        }
    }
}
