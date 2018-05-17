package com.sun.springbootTest.domain.p.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sun.springbootTest.domain.p.entity.Country;

public interface CountryRepository extends JpaRepository<Country,Long>{

}
