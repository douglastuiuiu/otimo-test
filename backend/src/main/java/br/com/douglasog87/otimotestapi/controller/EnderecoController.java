package br.com.douglasog87.otimotestapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.douglasog87.otimotestapi.model.Endereco;
import br.com.douglasog87.otimotestapi.service.EnderecoService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/enderecos")
public class EnderecoController {

    private final EnderecoService enderecoService;

    @GetMapping("/{cep}")
    public ResponseEntity<Endereco> get(@PathVariable String cep) {
        return ResponseEntity.ok(enderecoService.findByCep(cep));
    }


}
