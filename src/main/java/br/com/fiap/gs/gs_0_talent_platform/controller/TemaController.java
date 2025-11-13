package br.com.fiap.gs.gs_0_talent_platform.controller;

import br.com.fiap.gs.gs_0_talent_platform.dto.InfoResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemaController {

    @GetMapping("/info")
    public InfoResponse getInfo() {
        return new InfoResponse(
                "Plataformas que conectam talentos a projetos com propósito",
                "Gustavo Matos",        
                "Heitor Novaes",                
                "Plataforma digital que conecta profissionais a projetos alinhados a " +
                "causas sociais, ambientais ou de impacto positivo, permitindo que " +
                "organizações encontrem talentos com habilidades adequadas e interesse no propósito."
        );
    }
}
