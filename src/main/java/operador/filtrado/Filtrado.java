package operador.filtrado;

import model.Persona;
import operador.creacion.Creacion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Filtrado {
    private static final Logger log = LoggerFactory.getLogger(Creacion.class);
    public void filter(){
        //filter() -> filtrar un flujo de datos
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1,"Jessenia",27));
        personas.add(new Persona(2,"Juan Pablo",23));
        personas.add(new Persona(3,"Miguel",29));

        Flux.fromIterable(personas)
                .filter(p -> p.getEdad() > 28)
                .subscribe(p -> log.info(p.toString()));

    }

    public void  distinct(){
        //distinct -> elimina los elementos repetidos
        // en el caso de los objetos toma el valor para comprar la referencia a memoria
        // por eso es recomendable sobre escribir los mètods hashCode y equeals en las clases de los objetos
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1,"Jessenia",27));
        personas.add(new Persona(1,"Jessenia",27));
        personas.add(new Persona(2,"Miguel",29));

        Flux.fromIterable(personas)
                .distinct()
                .subscribe( p -> log.info(p.toString()));
    }

    public void take(){
        //take -> paràmetro un nùmero que indica cuantos elemento de una colección tomarà desde es principio
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1,"Jessenia",27));
        personas.add(new Persona(2,"Juan Pablo",23));
        personas.add(new Persona(3,"Miguel",29));

        Flux.fromIterable(personas)
                .take(2)
                .subscribe(p -> log.info(p.toString()));
    }

    public void takeLast(){
        //takeLast -> paràmetro un nùmero que indica cuantos elemento de una colección tomarà desde el final
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1,"Jessenia",27));
        personas.add(new Persona(2,"Juan Pablo",23));
        personas.add(new Persona(3,"Miguel",29));

        Flux.fromIterable(personas)
                .takeLast(1)
                .subscribe(p -> log.info(p.toString()));
    }
    public void skip(){
        //skip  paràmetro un nùmero que indica cuantos elementos de una colección se saltaá desde el inicio
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1,"Jessenia",27));
        personas.add(new Persona(2,"Juan Pablo",23));
        personas.add(new Persona(3,"Miguel",29));

        Flux.fromIterable(personas)
                .skip(1)
                .subscribe(p -> log.info(p.toString()));
    }
    public void skipLast(){
        //skip  paràmetro un nùmero que indica cuantos elementos de una colección se saltaá desde el inicio
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1,"Jessenia",27));
        personas.add(new Persona(2,"Juan Pablo",23));
        personas.add(new Persona(3,"Miguel",29));

        Flux.fromIterable(personas)
                .skipLast(2)
                .subscribe(p -> log.info(p.toString()));
    }
}
