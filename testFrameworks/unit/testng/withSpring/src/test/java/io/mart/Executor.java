package io.mart;

import org.springframework.stereotype.Service;

@Service
public class Executor {

    public String doRequest(){
        return "this is response";
    }
}
