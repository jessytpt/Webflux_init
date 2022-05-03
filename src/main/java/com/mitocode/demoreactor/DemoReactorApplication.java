package com.mitocode.demoreactor;

import io.reactivex.Observable;
import model.Persona;
import org.apache.commons.logging.Log;
import org.eclipse.sisu.inject.Logs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class DemoReactorApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(DemoReactorApplication.class);

	public void reactor(){
		Mono.just(new Persona(1,"Mito",10))
				.subscribe(p -> log.info("[Reactor] Persona: "+ p));
	}

	public void rxjava2(){
		Observable.just(new Persona(1,"Mito",10))
				.subscribe(p -> log.info("[RxJava2] Persona: "+ p));
	}


	public static void main(String[] args) {
		SpringApplication.run(DemoReactorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		reactor();
		rxjava2();
	}
}
