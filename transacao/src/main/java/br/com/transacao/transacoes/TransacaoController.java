package br.com.transacao.transacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {
    @Autowired
    private CartaoFeign cartaoFeign;

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody Cartao cartao){
        cartaoFeign.enviar(cartao);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable String id){
        cartaoFeign.parar(id);
        return ResponseEntity.ok().build();
    }
}
