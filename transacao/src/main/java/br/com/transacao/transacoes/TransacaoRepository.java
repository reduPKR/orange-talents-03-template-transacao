package br.com.transacao.transacoes;

import br.com.transacao.cartao.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, String> {
    Optional<Transacao> findTop10ByCartaoIdOrderByEfetivadaEmDesc(String id);

    Optional<Cartao> findCartaoId(String id);
}
