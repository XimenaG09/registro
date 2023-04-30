package com.ps.registro.controller;

import com.ps.registro.modelo.Persona;
import com.ps.registro.modelo.dto.ResponseErrorDTO;
import com.ps.registro.services.IPersonaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    IPersonaService iPersonaService;
    private static final Logger logger = LoggerFactory.getLogger(PersonaController.class);

    @GetMapping("/{id}")
    public ResponseEntity<?> consultar(@PathVariable("id") Long id){
        try {
            Persona resultado=  iPersonaService.consultar(id);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(resultado);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseErrorDTO(HttpStatus.BAD_REQUEST.toString(), e.getCause() + "", e.getMessage()));
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> guardar(@RequestBody Persona persona) {

        try {
            Persona resultado=  iPersonaService.guardar(persona);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(resultado);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseErrorDTO(HttpStatus.BAD_REQUEST.toString(), e.getCause() + "", e.getMessage()));
        }
    }

    @PutMapping("/")
    public ResponseEntity<?> actualizar(@RequestBody Persona persona) {
        try {
            Persona resultado=  iPersonaService.actualizar(persona);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(resultado);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseErrorDTO(HttpStatus.BAD_REQUEST.toString(), e.getCause() + "", e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrar(@PathVariable("id") Long id) {
        try {
            iPersonaService.borrar(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Usuario borrado");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseErrorDTO(HttpStatus.BAD_REQUEST.toString(), e.getCause() + "", e.getMessage()));
        }
    }


}
