package br.com.transacao.cartao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "CartaoFeign", url = "${api.cartao.url}")
public interface CartaoFeign {
    @PostMapping
    void enviar(@RequestBody CartaoRequest cartao);

    @DeleteMapping("/{id}")
    void parar(@PathVariable String id);
}
