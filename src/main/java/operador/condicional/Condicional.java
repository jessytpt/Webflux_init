package operador.condicional;

import com.mitocode.demoreactor.DemoReactorApplication;
import model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Condicional {
    private static final Logger log = LoggerFactory.getLogger(DemoReactorApplication.class);

    public void defaultEmpy(){
        //.defaultIfEmpty()
        // valor por defecto
        //Mono.empty()
        //Flux.empty()
        Mono.just(new Persona(0,"XYZ",99))
                .defaultIfEmpty(new Persona(1,"Default",25))
                .subscribe(x -> log.info(x.toString()));
    }
    public void  takeUntil(){
        //.takeUntil(condicion)
        // despliega una colección hasta el primer elemento que cumpla con la condición, todo lo que etsé después ya no lo toma encuenta
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1,"Jessenia",29));
        personas.add(new Persona(2,"Juan Pablo",27));
        personas.add(new Persona(3,"Miguel",22));

        Flux.fromIterable(personas)
                .takeUntil(p -> p.getEdad() > 23)
                .subscribe(x -> log.info(x.toString()));
    }
    public void  timeout() throws InterruptedException{
        //.takeUntil(condicion)
        // despliega una colección hasta el primer elemento que cumpla con la condición, todo lo que etsé después ya no lo toma encuenta
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1,"Jessenia",29));
        personas.add(new Persona(2,"Juan Pablo",27));
        personas.add(new Persona(3,"Miguel",22));

        Flux.fromIterable(personas)
                .delayElements(Duration.ofSeconds(3))
                .timeout(Duration.ofSeconds(2))
                .subscribe(x -> log.info(x.toString()));
        Thread.sleep(10000);
    }
}
