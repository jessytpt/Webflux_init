package operador.error;

import model.Persona;
import operador.creacion.Creacion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class ErrorOp {
    private static final Logger log = LoggerFactory.getLogger(Creacion.class);

    public void retry(){
        //retry -> tras un error en el flujo vuelve nuevamente a tratar de ejecutar el flujo
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1,"Jessenia",27));
        personas.add(new Persona(2,"Juan Pablo",23));
        personas.add(new Persona(3,"Miguel",29));

        Flux.fromIterable(personas)
                .concatWith(Flux.error(new RuntimeException("UN ERROR")))
                .retry(1)
                .doOnNext(x -> log.info(x.toString()))
                .subscribe();

    }
    public void errorReturn(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1,"Jessenia",27));
        personas.add(new Persona(2,"Juan Pablo",23));
        personas.add(new Persona(3,"Miguel",29));

        Flux.fromIterable(personas)
                .concatWith(Flux.error(new RuntimeException("UN ERROR")))
                .onErrorReturn(new Persona(0,"XYZ",99))
                .subscribe(x -> log.info(x.toString()));
    }
    public void errorResume(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1,"Jessenia",27));
        personas.add(new Persona(2,"Juan Pablo",23));
        personas.add(new Persona(3,"Miguel",29));

        Flux.fromIterable(personas)
                .concatWith(Flux.error(new RuntimeException("UN ERROR")))
                .onErrorResume(e -> Mono.just(new Persona(0,"XYZ",99)))
                .subscribe(x -> log.info(x.toString()));
    }
    public void errorMap(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1,"Jessenia",27));
        personas.add(new Persona(2,"Juan Pablo",23));
        personas.add(new Persona(3,"Miguel",29));

        Flux.fromIterable(personas)
                .concatWith(Flux.error(new RuntimeException("UN ERROR")))
                .onErrorMap(e -> new InterruptedException(e.getMessage()))
                .subscribe(x -> log.info(x.toString()));
    }
}
