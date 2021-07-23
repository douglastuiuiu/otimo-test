package br.com.douglasog87.otimotestapi.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.douglasog87.otimotestapi.model.Endereco;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EnderecoService {

    private final RestTemplate restTemplate;

    public Endereco findByCep(String cep) {
        String URL = "https://viacep.com.br/ws/" + cep + "/json/";
        return restTemplate.getForObject(URL, Endereco.class);
    }

}
