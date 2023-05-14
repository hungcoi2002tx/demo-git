package com.codevui.component.core;

import org.springframework.stereotype.Component;

@Component("tshirt")
public class TShirt implements IOutfit {

    @Override
    public void wear() {
        System.out.println("Mac Tshirt");
        
    }
    
    
}
