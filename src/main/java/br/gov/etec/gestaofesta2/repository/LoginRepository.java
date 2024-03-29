package br.gov.etec.gestaofesta2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.gov.etec.gestaofesta2.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
	
	Login findByEmail(String email);
	
}
