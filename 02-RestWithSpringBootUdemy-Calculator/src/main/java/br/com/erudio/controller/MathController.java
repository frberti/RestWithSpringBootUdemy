package br.com.erudio.controller;

import br.com.erudio.service.OperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @Autowired
    OperationsService service;

    @RequestMapping(value ="/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public ResponseEntity<Double> sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        Double sum = service.sum(numberOne, numberTwo);
        return ResponseEntity.ok().body(sum);
    }

    @RequestMapping(value ="/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public ResponseEntity<Double> subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        Double sum = service.subtraction(numberOne, numberTwo);
        return ResponseEntity.ok().body(sum);
    }

    @RequestMapping(value ="/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public ResponseEntity<Double> multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        Double sum = service.multiplication(numberOne, numberTwo);
        return ResponseEntity.ok().body(sum);
    }

    @RequestMapping(value ="/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public ResponseEntity<Double> division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        Double sum = service.division(numberOne, numberTwo);
        return ResponseEntity.ok().body(sum);
    }

    @RequestMapping(value ="/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public ResponseEntity<Double> mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        Double sum = service.mean(numberOne, numberTwo);
        return ResponseEntity.ok().body(sum);
    }

    @RequestMapping(value ="/squareRoot/{numberOne}", method = RequestMethod.GET)
    public ResponseEntity<Double> squareRoot(@PathVariable("numberOne") String numberOne) throws Exception {
        Double sum = service.squareRoot(numberOne);
        return ResponseEntity.ok().body(sum);
    }
}
