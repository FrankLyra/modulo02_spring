package br.com.franklyra.spring.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("v1")
public class MessageServiceImpl implements MessageService {
    @Override
    public String getMessage() {
        return "Hello, World!";
    }
}
