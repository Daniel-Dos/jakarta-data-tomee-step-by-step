package com.medium.danieldiasjava.exception;

import jakarta.data.exceptions.EmptyResultException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class EmptyResultExceptionMapper implements ExceptionMapper<EmptyResultException> {
    @Override
    public Response toResponse(EmptyResultException exception) {
        ErrorResponse error = new ErrorResponse(
                "Character not found",
                exception.getMessage()
        );
        return Response.status(Response.Status.NOT_FOUND)
                .entity(error)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}