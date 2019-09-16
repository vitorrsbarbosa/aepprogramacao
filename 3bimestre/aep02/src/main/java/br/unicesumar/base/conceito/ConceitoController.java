package br.unicesumar.base.conceito;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/conceito/")
public class ConceitoController {

    @Autowired
    private ConceitoRepository conceitoRepo;

    @GetMapping
    public List<Conceito> get() {
        return conceitoRepo.findAll();
    }

    @PostMapping
    public Conceito postConceito(@RequestBody Conceito conceito) {
        return conceitoRepo.save(conceito);
    }
    
    @GetMapping("{id}")
    public Conceito getConceitoById(@PathVariable String id) {
        return conceitoRepo.findById(id).orElseThrow(() 
        -> new RuntimeException("Não foi possível encontrar o conceito"));
    }

    @PutMapping("{id}")
    public void putConceito(@PathVariable String id, @RequestBody Conceito conceito) {
        if(!id.equals(conceito.getId())) {
            throw new RuntimeException("Os id devem ser iguais");
        }
        conceitoRepo.save(conceito);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        conceitoRepo.deleteById(id);
    }
}