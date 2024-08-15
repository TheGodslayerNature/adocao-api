package com.adocao_api.dto;

import com.adocao_api.model.PetModel;

public record PetResponseDto(String id, String nome, String raca, String imagem) {
    public PetResponseDto(PetModel pet) {
        this(pet.getId(), pet.getNome(), pet.getRaca(), pet.getImagem());
    }
}
