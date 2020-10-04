package com.spring.boot.rocks.webflux.repository;

import org.springframework.stereotype.Repository;

import com.spring.boot.rocks.webflux.domain.AppUser;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReactiveAppUserRepository implements AppUserRepository {

    private static List<AppUser> appUser = new ArrayList<>();

    static {
        appUser.add(new AppUser("TestUser1", 95));
        appUser.add(new AppUser("TestUser2", 82));
        appUser.add(new AppUser("TestUser3", 73));
        appUser.add(new AppUser("TestUser4", 72));
        appUser.add(new AppUser("TestUser5", 70));
    }

    @Override
    public Flux<AppUser> findAll() {
        //simulate stream data with 2 seconds delay.
        return Flux.fromIterable(appUser).delayElements(Duration.ofSeconds(1));
    }

}
