package com.ps.registro.services;

import com.ps.registro.modelo.Registro;
import com.ps.registro.repository.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistroService implements IRegistroService{

    @Autowired
    RegistroRepository registroRepository;

    public Registro guardar(Registro registro) throws Exception {

        if(registro.getId()<0){
            throw new Exception("El empleado no puede tener números menores o iguales a 0");
        }
        if (registro.getRegistro()==null) {
            throw new Exception("El usuario no tiene fecha de registro");
        }
        if(registro.getPersona_id()==null){
            throw new Exception("El usuario no tiene id");
        }

        return registroRepository.save(registro);
    }

    @Override
    public Registro consultar(Long id) throws Exception {

        if (id==null || id<1){
            throw new Exception("El id enviado no es valido");
        }
        return registroRepository.getOne(id);
    }

    @Override
    public Registro actualizar(Registro registro) throws Exception {
        Registro resultado=consultar((long) registro.getId());

        if(registro.getRegistro() != null && !registro.getRegistro().equals("")){
            resultado.setRegistro(registro.getRegistro());
        }
        return registroRepository.save(registro);
    }

    @Override
    public Registro borrar(Long id) throws Exception {
        if(registroRepository.existsById(id)){
            registroRepository.deleteById(id);
        }else {
            throw new Exception("El id enviado no es válido");
        }
        return null;
    }


}
