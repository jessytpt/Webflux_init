package operador.combinacion;

import model.Persona;
import model.Venta;
import operador.creacion.Creacion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Combinacion {

    private static final Logger log = LoggerFactory.getLogger(Creacion.class);

    public void merge(){
        List<Persona> persona1 = new ArrayList<>();
        persona1.add(new Persona(1,"Jessenia",27));
        persona1.add(new Persona(2,"Juan Pablo",23));
        persona1.add(new Persona(3,"Miguel",29));

        List<Persona> persona2 = new ArrayList<>();
        persona2.add(new Persona(1,"Jessenia",27));
        persona2.add(new Persona(2,"Juan Pablo",23));
        persona2.add(new Persona(3,"Miguel",29));

        List<Venta> ventas = new ArrayList<>();
        ventas.add( new Venta(1, LocalDateTime.now()));

        Flux<Persona> flux1 = Flux.fromIterable(persona1);
        Flux<Persona> flux2 = Flux.fromIterable(persona2);
        Flux<Venta> flux3 = Flux.fromIterable(ventas);

        Flux.merge(flux1,flux2,flux3)
                .subscribe(p -> log.info(p.toString()));

    }

    public void zip(){
        //Zip permite concatenar varios flujos en uno sòlo
        List<Persona> persona1 = new ArrayList<>();
        persona1.add(new Persona(1,"Jessenia",27));
        persona1.add(new Persona(2,"Juan Pablo",23));
        //persona1.add(new Persona(3,"Miguel",29));

        List<Persona> persona2 = new ArrayList<>();
        persona2.add(new Persona(1,"Jessenia",27));
        persona2.add(new Persona(2,"Juan Pablo",23));
        persona2.add(new Persona(3,"Miguel",29));

        List<Venta> ventas = new ArrayList<>();
        ventas.add( new Venta(1, LocalDateTime.now()));

        Flux<Persona> fx1 = Flux.fromIterable(persona1);
        Flux<Persona> fx2 = Flux.fromIterable(persona2);
        Flux<Venta> fx3 = Flux.fromIterable(ventas);

        Flux.zip(fx1,fx2,(p1,p2)->String.format("Flux 1: %s,Flux 2: %s",p1,p2))
                .subscribe(x -> log.info(x));
    }

    public void zipWith(){
        //Zip permite concatenar varios flujos en uno sòlo
        List<Persona> persona1 = new ArrayList<>();
        persona1.add(new Persona(1,"Jessenia",27));
        persona1.add(new Persona(2,"Juan Pablo",23));
        //persona1.add(new Persona(3,"Miguel",29));

        List<Persona> persona2 = new ArrayList<>();
        persona2.add(new Persona(1,"Jessenia",27));
        persona2.add(new Persona(2,"Juan Pablo",23));
        persona2.add(new Persona(3,"Miguel",29));

        List<Venta> ventas = new ArrayList<>();
        ventas.add( new Venta(1, LocalDateTime.now()));

        Flux<Persona> fx1 = Flux.fromIterable(persona1);
        Flux<Persona> fx2 = Flux.fromIterable(persona2);
        Flux<Venta> fx3 = Flux.fromIterable(ventas);

        fx1.zipWith(fx3,(p1,v1)-> String.format("Flux 1: %s,Flux 2: %s",p1,v1))
                .subscribe(x -> log.info(x.toString()));

    }
}
