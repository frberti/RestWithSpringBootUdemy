package br.com.erudio.controller;

import br.com.erudio.data.vo.PersonVO;
import br.com.erudio.data.vo.v2.PersonVOv2;
import br.com.erudio.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/person/v2")
public class PersonControllerV2 {

    @Autowired
    private PersonService service;

    @GetMapping(produces = {"application/xml", "application/json"})
    public List<PersonVOv2> findAllv2(){
        List<PersonVOv2> vo = service.findAllv2();
        return vo;
    }

    @PostMapping(produces = {"application/json", "application/xml"},
            consumes = {"application/json", "application/xml"})
    public PersonVOv2 create(@RequestBody PersonVOv2 v2){
        return service.createV2(v2);
    }
}
