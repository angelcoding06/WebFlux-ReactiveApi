package org.example.webfluxapi;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
// En este ejemplo, stringMono es un Publisher que emite un único valor: "Hello World!".
// Cuando llamamos a subscribe(), registramos un Subscriber (en forma de lambda) que reacciona cuando se emite el valor.
public class MonoFluxDemoTest {
    @Test
    public void testMono(){
        Mono<String> stringMono = Mono.just("Hello World!").log();

        stringMono.subscribe((element)-> {
            System.out.println("Subscribed " + element);
        });
    }

    @Test
    public void testFlux(){
        Flux<String> stringFlux = Flux.just("Apple","Banana","Orange","Mango").log();

        stringFlux.subscribe((element)->{
            System.out.println(element);
        });

    }
}
