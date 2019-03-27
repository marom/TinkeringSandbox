package com.marom.springrestclient.services;

import com.marom.springrestclient.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ApiService {

    List<User> getUsers(Integer limit);

    Flux<User> getUsersReactive(Mono<Integer> limit);
}
