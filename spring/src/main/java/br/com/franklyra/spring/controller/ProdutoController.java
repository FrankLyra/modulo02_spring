package br.com.franklyra.spring.controller;

import br.com.franklyra.spring.model.Produto;
import org.apache.coyote.Response;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

@RestController
public class ProdutoController {
    private final List<Produto> database;

    public ProdutoController() {
        this.database = new ArrayList<>(List.of(
                new Produto(1L, "Produto 1", 10.0),
                new Produto(2L, "Produto 2", 20.0),
                new Produto(3L, "Produto 3", 30.0)
        ));

    }

    @GetMapping("/produtos")
    public List<Produto> getProdutos() {
        return database;
    }

    @GetMapping("/produtos/sort")
    public ResponseEntity<List<Produto>> getProdutosOrdenados(@RequestParam(value = "order", required = false) String order) {
    if (order == null){
        return ResponseEntity.ok(database);
    }else if ("desc".equals(order)) {
            return ResponseEntity.ok(database.stream()
                    .sorted((Comparator.comparing(Produto::getNome)).reversed()).toList());
        } else if ("asc".equals(order)) {
            return ResponseEntity.ok(database.stream()
                    .sorted(Comparator.comparing(Produto::getNome)).toList());

        } else {
          return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/produtos/{id}")
    public Produto getProdutoById(@PathVariable Long id) {
        return database.stream()
                .filter(produto -> produto.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping("/produtos")
    public ResponseEntity<Produto> createProduto(@RequestBody Produto produto) {
        database.add(produto);
        return ResponseEntity.ok(produto);
    }

    @PutMapping("/produtos/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable int id, @RequestBody Produto produto) {

        int position = IntStream.range(0, database.size())
                .filter(i -> database.get(i).getId() == id)
                .findFirst()
                .orElse(-1);
        if (position >= 0) {
           database.set(position, produto);
            return ResponseEntity.ok(produto);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/produtos/{id}")
    public ResponseEntity<Produto> deleteProduto(@PathVariable int id) {
        int position = IntStream.range(0, database.size())
                .filter(i -> database.get(i).getId() == id)
                .findFirst()
                .orElse(-1);
        if (position >= 0) {
            Produto tmp = database.get(position);
            database.remove(position);
            return ResponseEntity.ok(tmp);
        }
        return ResponseEntity.notFound().build();
    }
}
