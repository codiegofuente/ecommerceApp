package com.app.ecommerce.exceptions;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import static com.app.ecommerce.utils.ExceptionConstants.ERROR;

@NoArgsConstructor
@Getter
@Data
public class ErrorException extends RuntimeException {

    private HttpStatus httpStatus;
    private String reason;
    private static final Logger log = LoggerFactory.getLogger(ErrorException.class);

    public ErrorException(HttpStatus httpStatus, String reason) {
        this.reason = reason;
        this.httpStatus = httpStatus;
        log.info(ERROR + httpStatus.toString() + " " + reason);
    }
}

