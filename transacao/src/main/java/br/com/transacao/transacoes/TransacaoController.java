package br.com.transacao.transacoes;

import br.com.transacao.cartao.Cartao;
import br.com.transacao.cartao.CartaoRequest;
import br.com.transacao.cartao.CartaoFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {
    @Autowired
    private TransacaoRepository transacaoRepository;
    @Autowired
    private CartaoFeign cartaoFeign;

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody CartaoRequest cartao){
        cartaoFeign.enviar(cartao);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable String id){
        cartaoFeign.parar(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> get10UltimasCompras(String id){
        Optional<Cartao> cartao = transacaoRepository.findCartaoId(id);
        if(cartao.isPresent()){
            Optional<Transacao> lista = transacaoRepository.findTop10ByCartaoIdOrderByEfetivadaEmDesc(id);
            ResponseEntity.ok(lista);
        }
        return ResponseEntity.notFound().build();
    }
}
