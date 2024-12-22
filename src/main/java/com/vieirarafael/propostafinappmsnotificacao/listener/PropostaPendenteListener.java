package com.vieirarafael.propostafinappmsnotificacao.listener;

import com.vieirarafael.propostafinappmsnotificacao.constante.MensagemConstante;
import com.vieirarafael.propostafinappmsnotificacao.domain.Proposta;
import com.vieirarafael.propostafinappmsnotificacao.service.NotificacaoSnsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
@Slf4j
@AllArgsConstructor
@Component
public class PropostaPendenteListener {
    private final NotificacaoSnsService notificacaoSnsService;

    @RabbitListener(queues = "${rabbitmq.queue.proposta.pendente}")
    public void propostaPendente(Proposta proposta) {
        var mensagem = MensagemConstante.PROPOSTA_EM_ANALISE.formatted(proposta.getUsuario().getNome());
        log.info(mensagem);
        notificacaoSnsService.notificar(proposta.getUsuario().getTelefone(), mensagem);
    }
}
