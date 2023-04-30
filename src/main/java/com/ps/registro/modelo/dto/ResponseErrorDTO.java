package com.ps.registro.modelo.dto;

import lombok.Data;

@Data
public class ResponseErrorDTO {
    private final String status;
    private final String error;
    private final String message;

    public ResponseErrorDTO(String status, String error, String message){
        this.status = status;
        this.error = error;
        this.message = message;
    }
}
