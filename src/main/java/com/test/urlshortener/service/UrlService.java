package com.test.urlshortener.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.test.urlshortener.entity.Url;
import com.test.urlshortener.repository.UrlRepository;

@Service
public class UrlService {
	@Autowired
	private UrlRepository urlRepository;

	@Value("${urlshortener.domain}")
	private String domain;

	private static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final int ALPHABET_SIZE = ALPHABET.length();

	public Url saveUrl(Url url) {
		return urlRepository.save(url);
	}

	public Url getUrlByUrlComplete(String urlComplete) {
		return urlRepository.findByUrlComplete(urlComplete);
	}

	/**
	 * This method is used to generate a shortened url by full url
	 */
	public String generateShortenedUrl(String urlComplete) {
		Url url = getUrlByUrlComplete(urlComplete);
		if (url != null) {
			return domain + url.getUrlRaccourcie();
		} else {
			String raccourcie;
			do {
				raccourcie = getStrFromRandom();
				url = urlRepository.findByUrlRaccourcie(raccourcie);
			} while (url != null);

			url = new Url(urlComplete);
			url.setUrlRaccourcie(raccourcie);
			url = saveUrl(url);
			return domain + url.getUrlRaccourcie();
		}

	}

	/**
	 * This method is used to search a url by shortened url
	 */
	public Url getUrlByUrlRaccourcie(String urlRaccourcie) {
		String subRaccourcie = urlRaccourcie.substring(domain.length(), urlRaccourcie.length());
		return urlRepository.findByUrlRaccourcie(subRaccourcie);
	}

	/**
	 * This method is used to generate a string whose length is between 1 and 10
	 * characters
	 */
	public String getStrFromRandom() {
		StringBuilder str = new StringBuilder();
		int num = 1 + (int) (Math.random() * 10);
		for (int i = 0; i < num; i++) {
			int n = (int) (Math.random() * ALPHABET_SIZE);
			str.insert(0, ALPHABET.charAt(n));
		}
		return str.toString();
	}

}
