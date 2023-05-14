package com.codevui.component.core;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Girl {

    public IOutfit outfit;
    String name;
    
    @Autowired
    public Girl(@Qualifier("tshirt") IOutfit outfit){
        this.outfit = outfit;
        System.out.println("Contructor");
    }

    public Girl(String name){
        System.out.println("setter");
        this.name = name;
    }

    @PostConstruct
    public void postContructFunction(){
        System.out.println("bean vua dc tao xong");
    }
    
    @PreDestroy
    public void preDestroyFucnction(){
        System.out.println("trc khi bi xoa khoi application Context");
    }
}
