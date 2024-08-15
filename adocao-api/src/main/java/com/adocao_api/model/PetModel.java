package com.adocao_api.model;

import com.adocao_api.dto.PetRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
