package com.example.Vaccinizer.exception;

public class NotEligibleForDoseException extends Exception{

    public NotEligibleForDoseException(String message){
        super(message);
    }
}
