package br.com.transacao.kafka;

import br.com.transacao.transacoes.Transacao;
import br.com.transacao.transacoes.TransacaoRepository;
import br.com.transacao.transacoes.TransacaoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ListenerDeTransacao {
    @Autowired
    private TransacaoRepository transacaoRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransacaoResponse transacao) {
        System.out.println("******************************");
        System.out.println("Nova transação");

        LocalDateTime efetivadaEm = efetuarTransacao(transacao);
        System.out.println(transacao.getId());
        System.out.println(transacao.getCartaoId());
        System.out.println(transacao.getEstabelecimentoNome());
        System.out.println(transacao.getValor());
        System.out.println(efetivadaEm);
    }

    private LocalDateTime efetuarTransacao(TransacaoResponse transacaoResponse) {
        Transacao transacao = transacaoResponse.toModel();
        transacaoRepository.save(transacao);
        return transacao.getEfetivadaEm();
    }

}
