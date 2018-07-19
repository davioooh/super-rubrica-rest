package com.davioooh.srr.services;

import java.util.Map;

public interface TokenService {

  String create(String username);

  Map<String, Object> verify(String token);

}