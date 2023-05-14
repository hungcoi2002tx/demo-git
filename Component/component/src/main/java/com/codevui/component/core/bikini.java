package com.codevui.component.core;

import org.springframework.stereotype.Component;

@Component("bikini")

public class bikini implements IOutfit {
    public void wear(){
        System.out.println("Mac bikini");
    }
}
