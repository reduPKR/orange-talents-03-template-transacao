package br.com.transacao.transacoes;

import br.com.transacao.cartao.Cartao;
import br.com.transacao.cartao.CartaoRequest;
import br.com.transacao.cartao.CartaoFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/{id}")
    public ResponseEntity<?> get10UltimasCompras(@PathVariable String id){
        Optional<Transacao> cartao = transacaoRepository.findFirstByCartaoId(id);
        if(cartao.isPresent()){
            List<Transacao> lista = transacaoRepository.findTop10ByCartaoIdOrderByEfetivadaEmDesc(id);
            if(!lista.isEmpty())
                return ResponseEntity.ok(lista);
        }
        return ResponseEntity.notFound().build();
    }
}
