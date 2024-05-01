package org.backendprojectsst.hotelmanagementsystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(InvalidRoomIDException.class)
    public ResponseEntity<String> handleInvalidRoomIDException(InvalidRoomIDException e)
    {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RoomAlreadyOccupiedException.class)
    public ResponseEntity<String> handleRoomAlreadyOccupiedException(RoomAlreadyOccupiedException e)
    {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }


}
