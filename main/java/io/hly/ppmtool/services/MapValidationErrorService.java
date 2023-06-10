package io.hly.ppmtool.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

//Refactor Project controller
@Service
// map the key field and the error message thrown by JPA
public class MapValidationErrorService {
    public ResponseEntity<?>MapValidationService(BindingResult result){
        if(result.hasErrors()){

            Map<String, String> errorMap = new HashMap<>();
            for(FieldError error : result.getFieldErrors() ){
                errorMap.put(error.getField(),error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }
        return null;
    }

}
