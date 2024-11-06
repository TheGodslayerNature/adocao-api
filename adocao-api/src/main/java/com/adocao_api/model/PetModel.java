package com.adocao_api.model;

import com.adocao_api.dto.PetRequestDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PetModel {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(updatable = false, nullable = false)
    private String id;

    private String nome;

    private String raca;

    private String imagem;

    public PetModel(PetRequestDto dto){
        this.nome = dto.nome();
        this.raca = dto.raca();
        this.imagem = dto.imagem();
    }
}
