package leo.examples.restkafka.controller;

import leo.examples.restkafka.data.PedidoData;
import leo.examples.restkafka.services.RegistraEventoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PedidosController {
    private final RegistraEventoService eventoService;

    @PostMapping(path = "/api/salva-pedido")
    public ResponseEntity<String> SalvarPedido(@RequestBody PedidoData pedido) {
        eventoService.AdicionarEvento("SalvarPedido", pedido);
        return ResponseEntity.ok("Pedido salvo com sucesso!");
    }
}
