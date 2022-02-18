package br.com.erudio.service;

import br.com.erudio.converter.DozerConverter;
import br.com.erudio.converter.custom.PersonConverter;
import br.com.erudio.data.model.Person;
import br.com.erudio.data.vo.PersonVO;
import br.com.erudio.data.vo.v2.PersonVOv2;
import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    @Autowired
    PersonConverter converter;

    public PersonVO create(PersonVO personVO){
        Person entity = DozerConverter.parseObject(personVO, Person.class);
        PersonVO vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public PersonVOv2 createV2(PersonVOv2 personVOv2) {
        Person entity = converter.convertVOToEntity(personVOv2);
        PersonVOv2 vo = converter.convertEntityToVO(repository.save(entity));
        return vo;
    }

    public PersonVO update(PersonVO personVO) {
        Person entity = DozerConverter.parseObject(personVO, Person.class);
        repository.findById(entity.getId()).orElseThrow(() -> new ResourceNotFoundException("No resource for this ID"));
        entity.setFirstName(personVO.getFirstName());
        entity.setLastName(personVO.getLastName());
        entity.setAddress(personVO.getAddress());
        entity.setGender(personVO.getGender());
        PersonVO vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public PersonVO findById(Long id){
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records for this ID"));
        PersonVO vo = DozerConverter.parseObject(entity, PersonVO.class);
        return vo;
    }

    public List<PersonVO> findAll() {
        List<PersonVO> personVOS = DozerConverter.parseListObjects(repository.findAll(), PersonVO.class);
        return personVOS;
    }

    public void delete(Long id) {
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records for this ID"));
        repository.delete(entity);
    }


    public List<PersonVOv2> findAllv2() {
        List<PersonVOv2> vos = new ArrayList<>();
        List<Person> persons = repository.findAll();
        for (Person person: persons) {
            PersonVOv2 vo = converter.convertEntityToVO(person);
            vos.add(vo);
        }
        return vos;
    }
}
