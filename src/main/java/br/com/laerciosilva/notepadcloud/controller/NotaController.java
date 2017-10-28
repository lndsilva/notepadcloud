package br.com.laerciosilva.notepadcloud.controller;

import br.com.laerciosilva.notepadcloud.component.NotaComponent;
import br.com.laerciosilva.notepadcloud.model.Nota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "nota")
public class NotaController {
    @Autowired
    public NotaComponent notaComponent;

    @GetMapping("/titulo/{titulo}")
    public Nota buscaNota(@PathVariable(value = "titulo") String titulo) {
        return notaComponent.buscarNota(titulo);
    }

    @GetMapping()
    public List<Nota> findAll(){
        return notaComponent.findAll();
    }
    /*
    @DeleteMapping("/titulo/(titulo)")
    public void apagar(@PathVariable(value = "titulo")String titulo) {
        notaComponent.apagar(titulo);
    }

    @DeleteMapping()
    public void apagarTodos(){
        notaComponent.apagarTodos();
    }*/
    @PostMapping
    public void salvar(@RequestBody Nota nota){
        notaComponent.salvar(nota);
    }


}
