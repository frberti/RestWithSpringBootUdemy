package br.com.erudio.controller;

import br.com.erudio.data.vo.PersonVO;
import br.com.erudio.data.vo.v2.PersonVOv2;
import br.com.erudio.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping
    public List<PersonVO> findAll(){
        List<PersonVO> personsVO = service.findAll();
        return personsVO;
    }

    @GetMapping("/v2")
    public List<PersonVOv2> findAllv2(){
        List<PersonVOv2> vo = service.findAllv2();
        return vo;
    }

    @GetMapping("/{id}")
    public PersonVO findById(@PathVariable ("id") Long id){
        return service.findById(id);
    }

    @PostMapping
    public PersonVO create(@RequestBody PersonVO personVO){
        return service.create(personVO);
    }

    @PostMapping("/v2")
    public PersonVOv2 createV2(@RequestBody PersonVOv2 vo){
        return service.createV2(vo);
    }

    @PutMapping
    public PersonVO update(@RequestBody PersonVO personVO){
        return service.update(personVO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
