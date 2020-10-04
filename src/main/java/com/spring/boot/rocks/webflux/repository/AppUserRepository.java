package com.spring.boot.rocks.webflux.repository;

import com.spring.boot.rocks.webflux.domain.AppUser;

import reactor.core.publisher.Flux;

public interface AppUserRepository {

    Flux<AppUser> findAll();

}
