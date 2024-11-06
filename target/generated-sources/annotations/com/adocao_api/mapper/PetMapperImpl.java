package com.adocao_api.mapper;

import com.adocao_api.dto.PetRequestDto;
import com.adocao_api.model.PetModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-06T11:53:33-0300",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.2 (Amazon.com Inc.)"
)
@Component
public class PetMapperImpl implements PetMapper {

    @Override
    public PetModel toPet(PetRequestDto requestDto) {
        if ( requestDto == null ) {
            return null;
        }

        PetModel.PetModelBuilder petModel = PetModel.builder();

        petModel.nome( requestDto.nome() );
        petModel.raca( requestDto.raca() );
        petModel.imagem( requestDto.imagem() );

        return petModel.build();
    }

    @Override
    public PetModel toPet(String id, PetRequestDto requestDto) {
        if ( id == null && requestDto == null ) {
            return null;
        }

        PetModel.PetModelBuilder petModel = PetModel.builder();

        if ( requestDto != null ) {
            petModel.nome( requestDto.nome() );
            petModel.raca( requestDto.raca() );
            petModel.imagem( requestDto.imagem() );
        }
        petModel.id( id );

        return petModel.build();
    }
}
