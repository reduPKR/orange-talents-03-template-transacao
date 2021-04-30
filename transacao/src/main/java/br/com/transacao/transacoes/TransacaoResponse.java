package br.com.transacao.transacoes;

import br.com.transacao.cartao.CartaoResponse;
import br.com.transacao.estabelecimento.EstabelecimentoResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoResponse {
    private String id;
    private BigDecimal valor;
    private EstabelecimentoResponse estabelecimento;
    private CartaoResponse cartao;
    private LocalDateTime efetivadoEm;

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoResponse getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoResponse getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadoEm() {
        return efetivadoEm;
    }

    public String getCartaoId() {
        return cartao.getId();
    }

    public String getEstabelecimentoNome() {
        return estabelecimento.getNome();
    }

    public Transacao toModel() {
        return new Transacao(
                id,
                valor,
                estabelecimento.toModel(),
                cartao.toModel()
        );
    }
}
