package transformacion;

import model.Persona;
import operador.creacion.Creacion;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Transformacion {
    private static final Logger log = LoggerFactory.getLogger(Creacion.class);

    public void map(){
  /*      List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1,"Jessenia",27));
        personas.add(new Persona(2,"Juan Pablo",23));
        personas.add(new Persona(3,"Miguel",29));

        Flux.fromIterable(personas)
                .map(p -> {
                    p.setEdad(p.getEdad()+10);
                    return p;
                })
                .subscribe( p -> log.info(p.toString()));
  */
        Flux<Integer> fx = Flux.range(0,10);
        //fx.map(x-> x+10);
        //fx.subscribe(x -> log.info("x: "+ x));
        Flux<Integer> fx2 = fx.map(x-> x+10);
        fx2.subscribe(x -> log.info("x: "+ x));

    }

    public void flatMap(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1,"Jessenia",27));
        personas.add(new Persona(2,"Juan Pablo",23));
        personas.add(new Persona(3,"Miguel",29));

        //Mètodo flatMap trata una coleccion como flujo de datos
        // y devulve un sólo elemento del flujo de datos
        // en el medio permite aplicar lógica
        // es decir recive un Flux pero devuelve un Mono
        Flux.fromIterable(personas)
                .flatMap(p ->{
                    p.setEdad(p.getEdad()+5);
                    return Mono.just(p);
                })
                .subscribe(p -> log.info(p.toString()));
    }
    public void groupBy(){
        //groupBy -> devuelve flujos de datos agrupados por un citerio
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1,"Jessenia",27));
        personas.add(new Persona(2,"Juan Pablo",23));
        personas.add(new Persona(1,"Miguel",29));

        Flux.fromIterable(personas)
                .groupBy(Persona::getIdPersona)
                .flatMap(idFlux -> idFlux.collectList())
                .subscribe(x -> log.info(x.toString()));
    }
}
