package com.huseyinyetisir.countryapi;

import com.huseyinyetisir.countryapi.model.Country;
import com.huseyinyetisir.countryapi.repository.CountryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CountryapiApplication implements CommandLineRunner{

	private final CountryRepository countryRepository;

	public CountryapiApplication(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CountryapiApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Country c1 = Country.builder()
				.id("1234567")
				.name("Almanya")
				.president("Obama")
				.build();
		Country c2 = Country.builder()
				.id("2234567")
				.name("Türkiye")
				.president("Erdoğan")
				.build();
		Country c3 = Country.builder()
				.id("3234567")
				.name("İngiltere")
				.president("Merkel")
				.build();
		countryRepository.saveAll(Arrays.asList(c1, c2, c3));

	}
}
