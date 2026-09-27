package mx.edu.utez.proyecto4C.controller;

import jakarta.validation.Valid;
import mx.edu.utez.proyecto4C.controller.dto.RequestBodyDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin({"*"}) //Se permiten todos los origenes
@RequestMapping("/my-services")
public class MyController {

    @GetMapping
    public String miPrimerServicio(){
        return "Hello World!";
    }

    @GetMapping("/servicio2")
    public String Servicio2(){
        return "Segundo Servicio";
    }

    @PostMapping
    public String servicio3(){
        return "Este es el servicio 3";
    }

    @GetMapping("/path/{id}")
    public String pathVariable(@PathVariable String id){
        return "el pathvariable es: " + id;
    }

    @PostMapping("/body")
    public ResponseEntity<RequestBodyDTO> body(@RequestBody @Valid RequestBodyDTO payload){
        System.out.println(payload.getNombre());
        System.out.println(payload.getEdad());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(payload);
    }

    @PostMapping("/fizzbuzz/{n}")
    public String fizzBuzz(@PathVariable int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
        return "Elias Hurtado";
    }

    @PostMapping("/fibonacci/{n}")
    public String fibonacci(@PathVariable int n){
        long a = 0;
        long b = 1;

        for (int i = 0; i < n; i++) {
            System.out.println(a);
            long siguiente = a + b;
            a = b;
            b = siguiente;
        }
        return "Elias Hurtado";
    }
}
