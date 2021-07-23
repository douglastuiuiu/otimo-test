package br.com.douglasog87.otimotestapi.model;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.apache.commons.lang3.RandomStringUtils;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import br.com.douglasog87.otimotestapi.enums.TipoEmpresa;

public class EmpresaTest {

    private static Validator validator;
    private Empresa empresaEntity;

    @BeforeClass
    public static void setupValidatorInstance() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Before
    public void init() {
        empresaEntity = Empresa.builder()
            .id(1)
            .nome(RandomStringUtils.randomAlphabetic(50))
            .cnpj(RandomStringUtils.randomNumeric(14))
            .tipo(TipoEmpresa.MATRIZ.toString())
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
    public void whenOK_thenNoConstraintViolations() {
        Set<ConstraintViolation<Empresa>> violations = validator.validate(empresaEntity);
        Assertions.assertThat(violations.size()).isEqualTo(0);
    }


    @Test
    public void whenNullNome_thenOneConstraintViolations() {
        Empresa nomeNull = new Empresa();
        BeanUtils.copyProperties(empresaEntity, nomeNull);
        nomeNull.setNome(null);

        Set<ConstraintViolation<Empresa>> violations = validator.validate(nomeNull);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void whenEmptyNome_thenOneConstraintViolations() {
        Empresa nomeEmpty = new Empresa();
        BeanUtils.copyProperties(empresaEntity, nomeEmpty);
        nomeEmpty.setNome("");

        Set<ConstraintViolation<Empresa>> violations = validator.validate(nomeEmpty);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void whenBlankNome_thenOneConstraintViolations() {
        Empresa nomeBlank = new Empresa();
        BeanUtils.copyProperties(empresaEntity, nomeBlank);
        nomeBlank.setNome(" ");

        Set<ConstraintViolation<Empresa>> violations = validator.validate(nomeBlank);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void whenInvalidLongNome_thenOneConstraintViolations() {
        Empresa nomeBlank = new Empresa();
        BeanUtils.copyProperties(empresaEntity, nomeBlank);
        nomeBlank.setNome(RandomStringUtils.randomAlphabetic(51));

        Set<ConstraintViolation<Empresa>> violations = validator.validate(nomeBlank);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }


    @Test
    public void whenNullCnpj_thenOneConstraintViolations() {
        Empresa cnpjNull = new Empresa();
        BeanUtils.copyProperties(empresaEntity, cnpjNull);
        cnpjNull.setCnpj(null);

        Set<ConstraintViolation<Empresa>> violations = validator.validate(cnpjNull);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void whenEmptyCnpj_thenOneConstraintViolations() {
        Empresa cnpjEmpty = new Empresa();
        BeanUtils.copyProperties(empresaEntity, cnpjEmpty);
        cnpjEmpty.setCnpj("");

        Set<ConstraintViolation<Empresa>> violations = validator.validate(cnpjEmpty);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void whenBlankCnpj_thenOneConstraintViolations() {
        Empresa cnpjBlank = new Empresa();
        BeanUtils.copyProperties(empresaEntity, cnpjBlank);
        cnpjBlank.setCnpj(" ");

        Set<ConstraintViolation<Empresa>> violations = validator.validate(cnpjBlank);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void whenInvalidShortCnpj_thenOneConstraintViolations() {
        Empresa cnpjInvalidShort = new Empresa();
        BeanUtils.copyProperties(empresaEntity, cnpjInvalidShort);
        cnpjInvalidShort.setCnpj(RandomStringUtils.randomNumeric(13));

        Set<ConstraintViolation<Empresa>> violations = validator.validate(cnpjInvalidShort);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void whenInvalidLongCnpj_thenOneConstraintViolations() {
        Empresa cnpjInvalidLong = new Empresa();
        BeanUtils.copyProperties(empresaEntity, cnpjInvalidLong);
        cnpjInvalidLong.setCnpj(RandomStringUtils.randomNumeric(15));

        Set<ConstraintViolation<Empresa>> violations = validator.validate(cnpjInvalidLong);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void whenInvalidCnpj_thenOneConstraintViolations() {
        Empresa cnpjInvalid = new Empresa();
        BeanUtils.copyProperties(empresaEntity, cnpjInvalid);
        cnpjInvalid.setCnpj(RandomStringUtils.randomAlphabetic(14));

        Set<ConstraintViolation<Empresa>> violations = validator.validate(cnpjInvalid);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }


    @Test
    public void whenNullTipo_thenOneConstraintViolations() {
        Empresa tipoNull = new Empresa();
        BeanUtils.copyProperties(empresaEntity, tipoNull);
        tipoNull.setTipo(null);

        Set<ConstraintViolation<Empresa>> violations = validator.validate(tipoNull);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }


    @Test
    public void whenNullRazaoSocial_thenOneConstraintViolations() {
        Empresa razaoSocialNull = new Empresa();
        BeanUtils.copyProperties(empresaEntity, razaoSocialNull);
        razaoSocialNull.setRazaoSocial(null);

        Set<ConstraintViolation<Empresa>> violations = validator.validate(razaoSocialNull);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void whenEmptyRazaoSocial_thenOneConstraintViolations() {
        Empresa razaoSocialEmpty = new Empresa();
        BeanUtils.copyProperties(empresaEntity, razaoSocialEmpty);
        razaoSocialEmpty.setRazaoSocial("");

        Set<ConstraintViolation<Empresa>> violations = validator.validate(razaoSocialEmpty);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void whenBlankRazaoSocial_thenOneConstraintViolations() {
        Empresa razaoSocialBlank = new Empresa();
        BeanUtils.copyProperties(empresaEntity, razaoSocialBlank);
        razaoSocialBlank.setRazaoSocial(" ");

        Set<ConstraintViolation<Empresa>> violations = validator.validate(razaoSocialBlank);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void whenInvalidLongRazaoSocial_thenOneConstraintViolations() {
        Empresa razaoSocialBlank = new Empresa();
        BeanUtils.copyProperties(empresaEntity, razaoSocialBlank);
        razaoSocialBlank.setRazaoSocial(RandomStringUtils.randomAlphabetic(41));

        Set<ConstraintViolation<Empresa>> violations = validator.validate(razaoSocialBlank);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }


    @Test
    public void whenNullContato_thenOneConstraintViolations() {
        Empresa contatoNull = new Empresa();
        BeanUtils.copyProperties(empresaEntity, contatoNull);
        contatoNull.setContato(null);

        Set<ConstraintViolation<Empresa>> violations = validator.validate(contatoNull);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void whenEmptyContato_thenOneConstraintViolations() {
        Empresa contatoEmpty = new Empresa();
        BeanUtils.copyProperties(empresaEntity, contatoEmpty);
        contatoEmpty.setContato("");

        Set<ConstraintViolation<Empresa>> violations = validator.validate(contatoEmpty);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void whenBlankContato_thenOneConstraintViolations() {
        Empresa contatoBlank = new Empresa();
        BeanUtils.copyProperties(empresaEntity, contatoBlank);
        contatoBlank.setContato(" ");

        Set<ConstraintViolation<Empresa>> violations = validator.validate(contatoBlank);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void whenInvalidLongContato_thenOneConstraintViolations() {
        Empresa contatoBlank = new Empresa();
        BeanUtils.copyProperties(empresaEntity, contatoBlank);
        contatoBlank.setContato(RandomStringUtils.randomAlphabetic(41));

        Set<ConstraintViolation<Empresa>> violations = validator.validate(contatoBlank);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }


    @Test
    public void whenNullEmail_thenOneConstraintViolations() {
        Empresa emailNull = new Empresa();
        BeanUtils.copyProperties(empresaEntity, emailNull);
        emailNull.setEmail(null);

        Set<ConstraintViolation<Empresa>> violations = validator.validate(emailNull);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void whenEmptyEmail_thenOneConstraintViolations() {
        Empresa emailEmpty = new Empresa();
        BeanUtils.copyProperties(empresaEntity, emailEmpty);
        emailEmpty.setEmail("");

        Set<ConstraintViolation<Empresa>> violations = validator.validate(emailEmpty);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void whenBlankEmail_thenOneConstraintViolations() {
        Empresa emailBlank = new Empresa();
        BeanUtils.copyProperties(empresaEntity, emailBlank);
        emailBlank.setEmail(" ");

        Set<ConstraintViolation<Empresa>> violations = validator.validate(emailBlank);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void whenInvalidLongEmail_thenOneConstraintViolations() {
        Empresa emailBlank = new Empresa();
        BeanUtils.copyProperties(empresaEntity, emailBlank);
        emailBlank.setEmail(RandomStringUtils.randomAlphabetic(41));

        Set<ConstraintViolation<Empresa>> violations = validator.validate(emailBlank);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void whenInvalidEmail_thenOneConstraintViolations() {
        Empresa emailBlank = new Empresa();
        BeanUtils.copyProperties(empresaEntity, emailBlank);
        emailBlank.setEmail("invalid email");

        Set<ConstraintViolation<Empresa>> violations = validator.validate(emailBlank);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }


    @Test
    public void whenNullCep_thenOneConstraintViolations() {
        Empresa cepNull = new Empresa();
        BeanUtils.copyProperties(empresaEntity, cepNull);
        cepNull.setCep(null);

        Set<ConstraintViolation<Empresa>> violations = validator.validate(cepNull);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void whenEmptyCep_thenOneConstraintViolations() {
        Empresa cepEmpty = new Empresa();
        BeanUtils.copyProperties(empresaEntity, cepEmpty);
        cepEmpty.setCep("");

        Set<ConstraintViolation<Empresa>> violations = validator.validate(cepEmpty);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void whenBlankCep_thenOneConstraintViolations() {
        Empresa cepBlank = new Empresa();
        BeanUtils.copyProperties(empresaEntity, cepBlank);
        cepBlank.setCep(" ");

        Set<ConstraintViolation<Empresa>> violations = validator.validate(cepBlank);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void whenInvalidShortCep_thenOneConstraintViolations() {
        Empresa cepBlank = new Empresa();
        BeanUtils.copyProperties(empresaEntity, cepBlank);
        cepBlank.setCep(RandomStringUtils.randomNumeric(7));

        Set<ConstraintViolation<Empresa>> violations = validator.validate(cepBlank);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void whenInvalidLongCep_thenOneConstraintViolations() {
        Empresa cepBlank = new Empresa();
        BeanUtils.copyProperties(empresaEntity, cepBlank);
        cepBlank.setCep(RandomStringUtils.randomNumeric(9));

        Set<ConstraintViolation<Empresa>> violations = validator.validate(cepBlank);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void whenInvalidCep_thenOneConstraintViolations() {
        Empresa cepBlank = new Empresa();
        BeanUtils.copyProperties(empresaEntity, cepBlank);
        cepBlank.setCep(RandomStringUtils.randomAlphabetic(8));

        Set<ConstraintViolation<Empresa>> violations = validator.validate(cepBlank);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }


    @Test
    public void whenNullEstado_thenOneConstraintViolations() {
        Empresa estadoNull = new Empresa();
        BeanUtils.copyProperties(empresaEntity, estadoNull);
        estadoNull.setEstado(null);

        Set<ConstraintViolation<Empresa>> violations = validator.validate(estadoNull);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void whenEmptyEstado_thenOneConstraintViolations() {
        Empresa estadoEmpty = new Empresa();
        BeanUtils.copyProperties(empresaEntity, estadoEmpty);
        estadoEmpty.setEstado("");

        Set<ConstraintViolation<Empresa>> violations = validator.validate(estadoEmpty);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void whenBlankEstado_thenOneConstraintViolations() {
        Empresa estadoBlank = new Empresa();
        BeanUtils.copyProperties(empresaEntity, estadoBlank);
        estadoBlank.setEstado(" ");

        Set<ConstraintViolation<Empresa>> violations = validator.validate(estadoBlank);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void whenInvalidLongEstado_thenOneConstraintViolations() {
        Empresa estadoBlank = new Empresa();
        BeanUtils.copyProperties(empresaEntity, estadoBlank);
        estadoBlank.setEstado(RandomStringUtils.randomAlphabetic(41));

        Set<ConstraintViolation<Empresa>> violations = validator.validate(estadoBlank);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }


    @Test
    public void whenNullBairro_thenOneConstraintViolations() {
        Empresa bairroNull = new Empresa();
        BeanUtils.copyProperties(empresaEntity, bairroNull);
        bairroNull.setBairro(null);

        Set<ConstraintViolation<Empresa>> violations = validator.validate(bairroNull);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void whenEmptyBairro_thenOneConstraintViolations() {
        Empresa bairroEmpty = new Empresa();
        BeanUtils.copyProperties(empresaEntity, bairroEmpty);
        bairroEmpty.setBairro("");

        Set<ConstraintViolation<Empresa>> violations = validator.validate(bairroEmpty);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void whenBlankBairro_thenOneConstraintViolations() {
        Empresa bairroBlank = new Empresa();
        BeanUtils.copyProperties(empresaEntity, bairroBlank);
        bairroBlank.setBairro(" ");

        Set<ConstraintViolation<Empresa>> violations = validator.validate(bairroBlank);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void whenInvalidLongBairro_thenOneConstraintViolations() {
        Empresa bairroBlank = new Empresa();
        BeanUtils.copyProperties(empresaEntity, bairroBlank);
        bairroBlank.setBairro(RandomStringUtils.randomAlphabetic(41));

        Set<ConstraintViolation<Empresa>> violations = validator.validate(bairroBlank);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }


    @Test
    public void whenNullCidade_thenOneConstraintViolations() {
        Empresa cidadeNull = new Empresa();
        BeanUtils.copyProperties(empresaEntity, cidadeNull);
        cidadeNull.setCidade(null);

        Set<ConstraintViolation<Empresa>> violations = validator.validate(cidadeNull);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void whenEmptyCidade_thenOneConstraintViolations() {
        Empresa cidadeEmpty = new Empresa();
        BeanUtils.copyProperties(empresaEntity, cidadeEmpty);
        cidadeEmpty.setCidade("");

        Set<ConstraintViolation<Empresa>> violations = validator.validate(cidadeEmpty);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void whenBlankCidade_thenOneConstraintViolations() {
        Empresa cidadeBlank = new Empresa();
        BeanUtils.copyProperties(empresaEntity, cidadeBlank);
        cidadeBlank.setCidade(" ");

        Set<ConstraintViolation<Empresa>> violations = validator.validate(cidadeBlank);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void whenInvalidLongCidade_thenOneConstraintViolations() {
        Empresa cidadeBlank = new Empresa();
        BeanUtils.copyProperties(empresaEntity, cidadeBlank);
        cidadeBlank.setCidade(RandomStringUtils.randomAlphabetic(41));

        Set<ConstraintViolation<Empresa>> violations = validator.validate(cidadeBlank);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }


    @Test
    public void whenNullLogradouro_thenOneConstraintViolations() {
        Empresa logradouroNull = new Empresa();
        BeanUtils.copyProperties(empresaEntity, logradouroNull);
        logradouroNull.setLogradouro(null);

        Set<ConstraintViolation<Empresa>> violations = validator.validate(logradouroNull);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void whenEmptyLogradouro_thenOneConstraintViolations() {
        Empresa logradouroEmpty = new Empresa();
        BeanUtils.copyProperties(empresaEntity, logradouroEmpty);
        logradouroEmpty.setLogradouro("");

        Set<ConstraintViolation<Empresa>> violations = validator.validate(logradouroEmpty);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void whenBlankLogradouro_thenOneConstraintViolations() {
        Empresa logradouroBlank = new Empresa();
        BeanUtils.copyProperties(empresaEntity, logradouroBlank);
        logradouroBlank.setLogradouro(" ");

        Set<ConstraintViolation<Empresa>> violations = validator.validate(logradouroBlank);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void whenInvalidLongLogradouro_thenOneConstraintViolations() {
        Empresa logradouroBlank = new Empresa();
        BeanUtils.copyProperties(empresaEntity, logradouroBlank);
        logradouroBlank.setLogradouro(RandomStringUtils.randomAlphabetic(41));

        Set<ConstraintViolation<Empresa>> violations = validator.validate(logradouroBlank);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }


    @Test
    public void whenInvalidLongComplemento_thenOneConstraintViolations() {
        Empresa complementoBlank = new Empresa();
        BeanUtils.copyProperties(empresaEntity, complementoBlank);
        complementoBlank.setComplemento(RandomStringUtils.randomAlphabetic(41));

        Set<ConstraintViolation<Empresa>> violations = validator.validate(complementoBlank);
        Assertions.assertThat(violations.size()).isGreaterThanOrEqualTo(1);
    }


}
