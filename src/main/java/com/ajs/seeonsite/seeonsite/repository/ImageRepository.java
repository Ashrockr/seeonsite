package com.ajs.seeonsite.seeonsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajs.seeonsite.seeonsite.model.Home;
import com.ajs.seeonsite.seeonsite.model.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

	Home findByHomeId(Long homeId);
}
