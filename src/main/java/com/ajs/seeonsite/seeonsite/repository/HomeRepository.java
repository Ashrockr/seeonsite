package com.ajs.seeonsite.seeonsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajs.seeonsite.seeonsite.model.Home;

@Repository
public interface HomeRepository extends JpaRepository<Home, Long> {

}
