package com.catolica.app;

import java.net.URI;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/electrodomesticos")
public class ElectrodomesticoController {
    private final ConcurrentMap<Long, Electrodomestico> electrodomesticos = new ConcurrentHashMap<>();
    private final AtomicLong siguienteId = new AtomicLong(1);

    @GetMapping
    public List<Electrodomestico> listar() {
        return List.copyOf(electrodomesticos.values());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Electrodomestico> buscarPorId(@PathVariable Long id) {
        Electrodomestico electrodomestico = electrodomesticos.get(id);
        return electrodomestico == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(electrodomestico);
    }

    @PostMapping
    public ResponseEntity<Electrodomestico> crear(@RequestBody Electrodomestico electrodomestico) {
        long id = siguienteId.getAndIncrement();
        electrodomestico.setId(id);
        electrodomesticos.put(id, electrodomestico);
        return ResponseEntity.created(URI.create("/api/electrodomesticos/" + id)).body(electrodomestico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Electrodomestico> actualizar(
            @PathVariable Long id,
            @RequestBody Electrodomestico electrodomestico) {
        if (!electrodomesticos.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }

        electrodomestico.setId(id);
        electrodomesticos.put(id, electrodomestico);
        return ResponseEntity.ok(electrodomestico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        return electrodomesticos.remove(id) == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.noContent().build();
    }
}