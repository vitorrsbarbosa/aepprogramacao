package br.unicesumar.base.aluno;

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
@RequestMapping("api/aluno/")
public class AlunoController {

    @Autowired
    private AlunoRepository repo;

    @GetMapping
    public List<Aluno> get() {
        return repo.findAll();
    }
    @GetMapping("{id}")
    public Aluno get(@PathVariable String id) {
        return repo.findById(id).get();
    }
    @PostMapping
    public String post(@RequestBody Aluno aluno) {
        repo.save(aluno);
        return aluno.getId();
    }
    @PutMapping("{id}")
    public void get(@PathVariable String id, @RequestBody Aluno aluno) {
        if(!id.equals(aluno.getId())) {
            throw new RuntimeException("Os id devem ser iguais");
        }
        repo.save(aluno);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }
}