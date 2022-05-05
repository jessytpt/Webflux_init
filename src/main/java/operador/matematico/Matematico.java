package operador.matematico;

import com.mitocode.demoreactor.DemoReactorApplication;
import model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Matematico {

    private static final Logger log = LoggerFactory.getLogger(DemoReactorApplication.class);

    public void  average(){
        //.averagingInt()
        // promedio de una colección
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1,"Jessenia",29));
        personas.add(new Persona(2,"Juan Pablo",27));
        personas.add(new Persona(3,"Miguel",22));

        Flux.fromIterable(personas)
                .collect(Collectors.averagingInt(Persona::getEdad))
                .subscribe(x -> log.info(x.toString()));
    }
    public void count(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1,"Jessenia",29));
        personas.add(new Persona(2,"Juan Pablo",27));
        personas.add(new Persona(3,"Miguel",22));

        Flux.fromIterable(personas)
                .count()
                .subscribe(x -> log.info("Cantidad: "+x));
    }
    public void min(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1,"Jessenia",29));
        personas.add(new Persona(2,"Juan Pablo",27));
        personas.add(new Persona(3,"Miguel",22));

        Flux.fromIterable(personas)
                .collect(Collectors.minBy(Comparator.comparing(Persona::getEdad)))
                .subscribe(x -> log.info(x.toString()));
    }
    public void sum(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1,"Jessenia",29));
        personas.add(new Persona(2,"Juan Pablo",27));
        personas.add(new Persona(3,"Miguel",22));

        Flux.fromIterable(personas)
                .collect(Collectors.summingInt(Persona::getEdad))
                .subscribe(x -> log.info("Suma: "+x));
    }
    public void summarizing(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1,"Jessenia",29));
        personas.add(new Persona(2,"Juan Pablo",27));
        personas.add(new Persona(3,"Miguel",22));

        Flux.fromIterable(personas)
                .collect(Collectors.summarizingInt(Persona::getEdad))
                .subscribe(x -> log.info("Resumen: "+x));
    }

}
