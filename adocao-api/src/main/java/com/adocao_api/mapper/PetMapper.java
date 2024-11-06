package com.adocao_api.mapper;

import com.adocao_api.dto.PetRequestDto;
import com.adocao_api.dto.PetResponseDto;
import com.adocao_api.model.PetModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PetMapper {

    PetModel toPet(PetRequestDto requestDto);
    PetModel toPet(String id,PetRequestDto requestDto);
}
