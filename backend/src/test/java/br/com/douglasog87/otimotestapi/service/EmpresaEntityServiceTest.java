package br.com.douglasog87.otimotestapi.service;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static com.googlecode.catchexception.CatchException.catchException;

import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.douglasog87.otimotestapi.enums.TipoEmpresa;
import br.com.douglasog87.otimotestapi.entity.EmpresaEntity;
import br.com.douglasog87.otimotestapi.repository.EmpresaRepository;

@RunWith(MockitoJUnitRunner.class)
public class EmpresaEntityServiceTest {

    @InjectMocks
    private EmpresaService service;

    @Mock
    private EmpresaRepository empresaRepository;

    private EmpresaEntity empresaEntity;

    @Before
    public void init() {
        empresaEntity = EmpresaEntity.builder()
            .id(1)
            .nome(RandomStringUtils.randomAlphabetic(50))
            .cnpj(RandomStringUtils.randomNumeric(14))
            .tipo(TipoEmpresa.MATRIZ)
            .matriz(null)
            .razaoSocial(RandomStringUtils.randomAlphabetic(40))
            .contato(RandomStringUtils.randomAlphabetic(40))
            .email(RandomStringUtils.randomAlphabetic(20).concat("@").concat(RandomStringUtils.randomAlphabetic(19)))
            .cep(RandomStringUtils.randomNumeric(8))
            .estado(RandomStringUtils.randomAlphabetic(40))
            .bairro(RandomStringUtils.randomAlphabetic(40))
            .cidade(RandomStringUtils.randomAlphabetic(40))
            .logradouro(RandomStringUtils.randomAlphabetic(40))
            .complemento(RandomStringUtils.randomAlphabetic(40))
            .build();
    }

    @Test
    public void whenGet_thenNoConstraintViolations() {
        when(empresaRepository.findById(empresaEntity.getId().intValue())).thenReturn(Optional.of(empresaEntity));

        service.findById(empresaEntity.getId());

        verify(empresaRepository).findById(empresaEntity.getId().intValue());
    }

    //finalizar implementar de testes do service

}
