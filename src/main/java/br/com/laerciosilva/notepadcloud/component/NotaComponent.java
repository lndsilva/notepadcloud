package br.com.laerciosilva.notepadcloud.component;

import br.com.laerciosilva.notepadcloud.model.Nota;
import br.com.laerciosilva.notepadcloud.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotaComponent {

    @Autowired
    NotaRepository notaRepository;

    public void salvar(Nota nota){
        List<Nota> notas = notaRepository.findByTitulo(nota.getTitulo());
        if (!notas.isEmpty()){
            nota.setId(notas.get(0).getId());
        }
        notaRepository.save(nota);
    }
    public List<Nota> findAll(){
        return notaRepository.findAll();
    }
    public void deleteAll(){
        notaRepository.deleteAll();
    }
    public Nota buscarNota(String titulo){
        Nota nota;
        List<Nota> notas = notaRepository.findByTitulo(titulo);
        if (notas.isEmpty()){
            return  new Nota();
        }else{
            return notas.get(0);
        }
    }
}
