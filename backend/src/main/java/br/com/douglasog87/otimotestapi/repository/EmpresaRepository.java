package br.com.douglasog87.otimotestapi.repository;

import br.com.douglasog87.otimotestapi.entity.EmpresaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends CrudRepository<EmpresaEntity, Integer> {

    //falta implementar filtros
    Page<EmpresaEntity> findAll(Pageable page);

}
