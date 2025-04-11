package br.com.api.CrudUsuarios.controller;

import br.com.api.CrudUsuarios.model.Usuario;
import br.com.api.CrudUsuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;


    @GetMapping
    public List<Usuario> listarTodos() {
        return service.listarTodos();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario) {
        Usuario criado = service.salvar(usuario);
        return ResponseEntity.ok(criado);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        if (!service.existePorId(id)) {
            return ResponseEntity.notFound().build();
        }
        Usuario atualizado = service.atualizar(id, usuario);
        return ResponseEntity.ok(atualizado);
    }


        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletar (@PathVariable Long id) {
            if (!service.existePorId(id)) {
                return ResponseEntity.notFound().build();
            }
                service.deletar(id);
                return ResponseEntity.noContent().build();

        }
    }

