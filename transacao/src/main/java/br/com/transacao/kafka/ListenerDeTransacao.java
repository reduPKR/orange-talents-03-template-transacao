package br.com.transacao.kafka;

import br.com.transacao.transacoes.Transacao;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerDeTransacao {
    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(Transacao transacao) {
        System.out.println("******************************");
        System.out.println(transacao.getId());
        System.out.println(transacao.getCartaoId());
        System.out.println(transacao.getEstabelecimentoNome());
        System.out.println(transacao.getValor());
        System.out.println(transacao.getEfetivadoEm());
    }

}
