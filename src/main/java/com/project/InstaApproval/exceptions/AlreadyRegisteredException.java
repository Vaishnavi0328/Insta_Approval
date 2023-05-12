package com.project.InstaApproval.exceptions;

public class AlreadyRegisteredException extends RuntimeException {

    public AlreadyRegisteredException(String message) {
        super(message);
    }

}