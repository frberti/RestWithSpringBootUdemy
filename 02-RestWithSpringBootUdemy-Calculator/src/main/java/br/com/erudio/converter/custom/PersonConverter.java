package br.com.erudio.converter.custom;

import br.com.erudio.data.model.Person;
import br.com.erudio.data.vo.v2.PersonVOv2;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonConverter {

    public PersonVOv2 convertEntityToVO (Person entity){
        PersonVOv2 vo = new PersonVOv2();
        vo.setId(entity.getId());
        vo.setFirstName(entity.getFirstName());
        vo.setLastName(entity.getLastName());
        vo.setAddress(entity.getAddress());
        vo.setGender(entity.getGender());
        vo.setBithday(new Date());
        return vo;
    }

    public Person convertVOToEntity(PersonVOv2 vo) {
        Person entity = new Person();
        entity.setId(vo.getId());
        entity.setFirstName(vo.getFirstName());
        entity.setLastName(vo.getLastName());
        entity.setAddress(vo.getAddress());
        entity.setGender(vo.getGender());
        return entity;
    }
}
