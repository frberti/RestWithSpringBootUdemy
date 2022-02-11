package br.com.erudio.service;

import br.com.erudio.exception.UnsuportedMathOperationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import static br.com.erudio.conversor.Conversor.convertToDouble;
import static br.com.erudio.conversor.Conversor.isNumeric;

@Service
public class OperationsService {

    public Double sum(String numberOne, String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsuportedMathOperationException("Please set a numeric value");
        }
        Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
        return sum;
    }

    public Double subtraction(String numberOne, String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportedMathOperationException("Please set a numeric value");
        }
        Double sum = convertToDouble(numberOne) - convertToDouble(numberTwo);
        return sum;
    }

    public Double multiplication(String numberOne, String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsuportedMathOperationException("Please set a numeric value");
        }
        Double sum = convertToDouble(numberOne) * convertToDouble(numberTwo);
        return sum;
    }

    public Double division(String numberOne, String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsuportedMathOperationException("Please set a numeric value");
        }
        Double sum = convertToDouble(numberOne) / convertToDouble(numberTwo);
        return sum;
    }

    public Double mean(String numberOne, String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsuportedMathOperationException("Please set a numeric value");
        }
        Double sum = (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
        return sum;
    }

    public Double squareRoot(String numberOne) throws Exception {
        if(!isNumeric(numberOne)){
            throw new UnsuportedMathOperationException("Please set a numeric value");
        }
        Double sum = Math.sqrt(convertToDouble(numberOne));
        return sum;
    }
}
