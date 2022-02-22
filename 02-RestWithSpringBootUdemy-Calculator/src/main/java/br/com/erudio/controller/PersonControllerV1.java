package br.com.erudio.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import br.com.erudio.data.vo.PersonVO;
import br.com.erudio.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/person/v1")
public class PersonControllerV1 {

    @Autowired
    private PersonService service;

    @GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
    public List<PersonVO> findAll(){
        List<PersonVO> personsVO = service.findAll();
        return personsVO;
    }

    @GetMapping(value = "/{id}",
            produces = {"application/json", "application/xml", "application/x-yaml"})
    public PersonVO findById(@PathVariable ("id") Long id){
        PersonVO vo =  service.findById(id);
        vo.add(linkTo(methodOn(PersonControllerV1.class).findById(id)).withSelfRel());
        return vo;
    }

    @PostMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    public PersonVO create(@RequestBody PersonVO personVO){
        return service.create(personVO);
    }

    @PutMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    public PersonVO update(@RequestBody PersonVO personVO){
        return service.update(personVO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
