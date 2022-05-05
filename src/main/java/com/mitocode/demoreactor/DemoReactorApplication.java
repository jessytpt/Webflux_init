package com.mitocode.demoreactor;

import operador.combinacion.Combinacion;
import operador.condicional.Condicional;
import operador.error.ErrorOp;
import operador.filtrado.Filtrado;
import io.reactivex.Observable;
import model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoReactorApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(DemoReactorApplication.class);

	public void reactor(){
		Mono.just(new Persona(1,"Mito",10))
				.doOnNext(p -> {
					//lógica adicional
					log.info("[Reactor] Persona: "+ p);
				})
				.subscribe(p -> log.info("[Reactor] Persona: "+ p));
	}

	public void rxjava2(){
		Observable.just(new Persona(1,"Mito",10))
				.doOnNext(p -> log.info("[Reactor] Persona: "+ p))
				.subscribe(p -> log.info("[RxJava2] Persona: "+ p));
	}

	public void mono(){
		Mono.just(new Persona(1,"Mito",10))
				.subscribe(p-> log.info(p.toString()));
	}

	public void flux(){
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1,"Jessenia",27));
		personas.add(new Persona(2,"Juan Pablo",23));
		personas.add(new Persona(3,"Miguel",29));

		Flux.fromIterable(personas).subscribe(p -> log.info(p.toString()));
	}

	//Convertir un flux en mono
public void fluxMono(){
	List<Persona> personas = new ArrayList<>();
	personas.add(new Persona(1,"Jessenia",27));
	personas.add(new Persona(2,"Juan Pablo",23));
	personas.add(new Persona(3,"Miguel",29));

	Flux<Persona> fx = Flux.fromIterable(personas);
	fx.collectList().subscribe(lista -> log.info(lista.toString()));

	}



	public static void main(String[] args) {
		SpringApplication.run(DemoReactorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//mono();
		//flux();
/*
		Creacion creacion = new Creacion();
		creacion.range();
		creacion.repeat();
*/
		//Transformacion app = new Transformacion();
		//app.map();
		//app.flatMap();
		//app.groupBy();

		//Filtrado app = new Filtrado();
		//app.distinct();
		//app.take();
		//app.takeLast();
		//app.skip();
		//app.skipLast();

		/*Combinacion app = new Combinacion();
		//app.merge();
		app.zipWith();*/

		/*ErrorOp app = new ErrorOp();
		app.retry();
		app.errorMap();*/

		Condicional app = new Condicional();
		//app.defaultEmpy();
		//app.takeUntil();
		app.timeout();
	}
}
