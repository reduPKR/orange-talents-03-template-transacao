package br.com.transacao.transacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
