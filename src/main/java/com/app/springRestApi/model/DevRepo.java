package com.app.springRestApi.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DevRepo extends JpaRepository<Developer, Integer> {

}
