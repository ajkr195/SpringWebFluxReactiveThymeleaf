package com.spring.boot.rocks.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;

import com.spring.boot.rocks.webflux.repository.AppUserRepository;

@Controller
public class AppUserController {

    @Autowired
    private AppUserRepository appUserRepository;

    @RequestMapping("/")
    public String index(final Model model) {

        // loads 1 and display 1, stream data, data driven mode.
        IReactiveDataDriverContextVariable reactiveDataDrivenMode =
                new ReactiveDataDriverContextVariable(appUserRepository.findAll(), 1);

        model.addAttribute("appUsers", reactiveDataDrivenMode);

        // classic, wait repository loaded all and display it.
        //model.addAttribute("appUsers", appUserRepository.findAll());

        return "index";

    }

}