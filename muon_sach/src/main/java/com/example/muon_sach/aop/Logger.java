package com.example.muon_sach.aop;

import com.example.muon_sach.doc_ghi_file.CSVLogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Aspect
@Component
public class Logger {

    private int visitorCount = 0;

    @Pointcut("execution(* com.example.muon_sach.service.BookService.*(..))")
    public void logBookService() {
    }

    @After("logBookService()")
    public void logAfterAction(JoinPoint joinPoint) {
        System.out.println("Action: " + joinPoint.getSignature().getName());
    }

    @AfterThrowing(pointcut = "logBookService()", throwing = "error")
    public void logError(JoinPoint joinPoint, Throwable error) {
        String methodName = joinPoint.getSignature().getName();
        String errorMessage = error.getMessage();

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        CSVLogger.logToCSV(methodName, errorMessage, timestamp);

        System.out.println("Error logged to CSV: " + methodName + " - " + errorMessage);
    }

    @Before("execution(* com.example.muon_sach.controller.BookController.*(..))")
    public void countVisitors() {
        visitorCount++;
        System.out.println("Visitor count: " + visitorCount);
    }
}
