package com.dot.config;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;


import java.nio.file.AccessDeniedException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({IllegalArgumentException.class, IllegalStateException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ModelAndView handleBadRequest(Exception ex) {
        ModelAndView mav = new ModelAndView("error/400");
        mav.addObject("error", ex.getMessage());
        return mav;
    }

    @ExceptionHandler({AccessDeniedException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ModelAndView handleUnauthorized(Exception ex) {
        ModelAndView mav = new ModelAndView("error/401");
        mav.addObject("error", ex.getMessage());
        return mav;
    }

//    @ExceptionHandler({ForbiddenException.class})
//    @ResponseStatus(HttpStatus.FORBIDDEN)
//    public ModelAndView handleForbidden(Exception ex) {
//        ModelAndView mav = new ModelAndView("error/403");
//        mav.addObject("error", ex.getMessage());
//        return mav;
//    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView handleNotFound(NotFoundException ex) {
        ModelAndView mav = new ModelAndView("error/404");
        mav.addObject("error", ex.getMessage());
        return mav;
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleInternalServerError(RuntimeException ex) {
        ModelAndView mav = new ModelAndView("error/500");
        mav.addObject("error", ex.getMessage());
        return mav;
    }
}


