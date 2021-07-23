package br.com.douglasog87.otimotestapi.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import br.com.douglasog87.otimotestapi.model.Endereco;

@RunWith(MockitoJUnitRunner.class)
public class EnderecoServiceTest {

    @InjectMocks
    private EnderecoService service;

    @Mock
    private RestTemplate restTemplate;

    private Endereco endereco;
    private String cep;

    @Before
    public void init() {
        String cep = "88131582";
        endereco = Endereco.builder().cep(cep).build();
    }

    @Test
    public void whenGetEndereco_thenNoConstraintViolations() {
        String URL = "https://viacep.com.br/ws/" + cep + "/json/";
        when(restTemplate.getForObject(URL, Endereco.class)).thenReturn(any());

        when(service.findByCep(cep)).thenReturn(Endereco.builder().cep(cep).build());
        Endereco endereco2 = service.findByCep(cep);
        Assert.assertEquals(endereco.getCep(), endereco2.getCep());
    }

}
