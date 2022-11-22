package interfaces;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.matchday.Utente;
import com.project.matchday.model.Schedina;

public interface ProfiloRepository extends JpaRepository<Schedina, Integer>{
	

    void setSaldoByEmail(String e,Double s);

	public ArrayList<Schedina> getSchedineByEmail(String email);
	
}
