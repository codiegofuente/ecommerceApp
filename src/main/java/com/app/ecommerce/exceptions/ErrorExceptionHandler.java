package com.app.ecommerce.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import javax.servlet.http.HttpServletRequest;

import static com.app.ecommerce.utils.ExceptionConstants.ERROR;
import static com.app.ecommerce.utils.ExceptionConstants.EXCEPTION;


@RestControllerAdvice
class ErrorExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(ErrorExceptionHandler.class);

    @ExceptionHandler(ErrorException.class)
    public ResponseEntity<ErrorResponse> errorHandler(HttpServletRequest req, ErrorException errorEx) {
        ErrorResponse errorRes = new ErrorResponse();
        errorRes.setCode(errorEx.getHttpStatus().value());
        errorRes.setReason(errorEx.getReason());
        errorRes.setPath(req.getRequestURI());

        log.error(EXCEPTION, errorRes);
        return new ResponseEntity<>(errorRes, errorEx.getHttpStatus());

    }

    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    public ResponseEntity<HttpServerErrorException.InternalServerError> internalErrorHandler(HttpServletRequest req,
                                                                                             HttpServerErrorException.InternalServerError internalServerError) {

        log.error(ERROR, internalServerError);
        return new ResponseEntity<>(internalServerError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
        public ResponseEntity<HttpClientErrorException.NotFound> notFoundErrorHandler(HttpServletRequest req,
                                                                                  HttpClientErrorException.NotFound notFoundError) {

        log.error(ERROR, notFoundError);
        return new ResponseEntity<>(notFoundError, HttpStatus.NOT_FOUND);
    }

}