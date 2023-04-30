package com.ps.registro.services;

import com.ps.registro.modelo.Registro;

public interface IRegistroService {

    Registro guardar(Registro registro) throws Exception;

    Registro consultar(Long id) throws Exception;

    Registro actualizar (Registro registro) throws  Exception;

    Registro borrar(Long id) throws Exception;
}
