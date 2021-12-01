package org.ik.service;

import lombok.AllArgsConstructor;
import org.ik.dto.CharRequest;
import org.ik.entity.CharacterEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@AllArgsConstructor
public class CharactersService {

    public CharacterEntity insert(CharRequest charRequest){
        CharacterEntity dto = new CharacterEntity();
        dto.setHouse(charRequest.getHouse());
        dto.setName(charRequest.getName());
        dto.setPatronus(charRequest.getPatronus());
        dto.setRole(charRequest.getRole());
        dto.setSchool(charRequest.getSchool());

        dto.persist();

        return dto;
    }


}
