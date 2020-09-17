package com.test.urlshortener.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.urlshortener.entity.Url;

public interface UrlRepository extends JpaRepository<Url, Integer> {

	Url findByUrlComplete(String urlComplete);

	Url findByUrlRaccourcie(String urlRaccourcie);

}
