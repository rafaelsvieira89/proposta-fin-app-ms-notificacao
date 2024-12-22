package com.vieirarafael.propostafinappmsnotificacao.service;

import com.amazonaws.services.sns.AmazonSNS;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@AllArgsConstructor
@Service
public class NotificacaoSnsService {

    private final AmazonSNS amazonSNS;

    public void notificar(String mensagem) {
      log.info(mensagem);

    }
}
