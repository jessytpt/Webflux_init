package operador.creacion;

import io.reactivex.Observable;
import model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Creacion {
    private static final Logger log = LoggerFactory.getLogger(Creacion.class);

    public void justFrom(){
        Mono.just(new Persona(1,"Karol G",30));
    }
    public void empty(){
        Mono.empty();
        Flux.empty();
        Observable.empty();
    }
    public void range(){
        Flux.range(0,3)
                .doOnNext(i -> log.info("i: "+ i))
                .subscribe();
    }
    public void repeat(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1,"Jessenia",27));
        personas.add(new Persona(2,"Juan Pablo",23));
        personas.add(new Persona(3,"Miguel",29));

      /*  Flux.fromIterable(personas)
                .repeat(3)
                .subscribe(p -> log.info(p.toString()));*/
        Mono.just(new Persona(1,"Hi ",8))
                .repeat(3)
                .subscribe(p -> log.info(p.toString()));
    }

}
