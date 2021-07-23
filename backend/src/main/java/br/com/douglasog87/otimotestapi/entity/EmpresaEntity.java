package br.com.douglasog87.otimotestapi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.douglasog87.otimotestapi.enums.TipoEmpresa;
import br.com.douglasog87.otimotestapi.model.Empresa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@Table(name = "empresa", schema = "cademp")
public class EmpresaEntity implements Serializable {

    private static final long serialVersionUID = -8530435004604807389L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cnpj;
    @Enumerated(EnumType.STRING)
    private TipoEmpresa tipo;
    @ManyToOne
    @JoinColumn(name = "empresa_matriz")
    private EmpresaEntity matriz;
    @Column(name = "razao_social")
    private String razaoSocial;
    private String contato;
    private String email;
    private String cep;
    private String estado;
    private String bairro;
    private String cidade;
    private String logradouro;
    private String complemento;

    public static EmpresaEntity parseEmpresaEntity(Empresa model) {
        return EmpresaEntity.builder()
            .id(model.getId())
            .nome(model.getNome())
            .cnpj(model.getCnpj())
            .tipo(TipoEmpresa.valueOf(model.getTipo()))
            .razaoSocial(model.getRazaoSocial())
            .contato(model.getContato())
            .email(model.getEmail())
            .cep(model.getCep())
            .estado(model.getEstado())
            .bairro(model.getBairro())
            .cidade(model.getCidade())
            .logradouro(model.getLogradouro())
            .complemento(model.getComplemento())
            .build();
    }

}
