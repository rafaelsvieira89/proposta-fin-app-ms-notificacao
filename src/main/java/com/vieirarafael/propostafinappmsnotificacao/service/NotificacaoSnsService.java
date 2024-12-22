package com.vieirarafael.propostafinappmsnotificacao.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class NotificacaoSnsService {
    public void notificar(String mensagem) {
      log.info(mensagem);
    }
}
