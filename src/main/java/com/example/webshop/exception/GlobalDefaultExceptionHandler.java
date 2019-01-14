package com.example.webshop.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;

// in the WebConfig added to @ComponentScan
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    // catching ProductNotFoundException
    @ExceptionHandler(ProductNotFoundException.class)
    public String handlerProductNotFoundException(Model model){
        model.addAttribute("errorTitle", "Product not found");
        model.addAttribute("errorDescription","The product you are looking for is not available now :(");
        return "error"; // view/error
    }

    // catching other Exceptions
    @ExceptionHandler(Exception.class)
    public String handlerException(Model model, Exception ex){
        System.out.println(ex.getMessage());
        model.addAttribute("errorTitle", "Something was wrong!");
        model.addAttribute("errorDescription",
                "something went wrong and we will fix it soon :("
                + ex.toString());
        return "error";
    }
}
