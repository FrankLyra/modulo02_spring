package br.com.franklyra.spring.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("v2")
public class MessageServiceImplV2 implements MessageService {
    @Override
    public String getMessage() {
        return "Hello, World! (V2)";
    }
}
