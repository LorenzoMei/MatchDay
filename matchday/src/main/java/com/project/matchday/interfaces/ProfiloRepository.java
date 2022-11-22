package interfaces;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.matchday.Utente;
import com.project.matchday.model.Schedina;

public interface ProfiloRepository extends JpaRepository<Utente, Integer>{
	
//	@Query("SELECT * FROM schedina WHERE idUtente=fk_utente ")

	@Query(value = "UPDATE utente SET saldo=s WHERE email=e")
    void setSaldoByEmail(String e,Double s);

	public ArrayList<Schedina> getSchedineByEmail(String email);
	
}
