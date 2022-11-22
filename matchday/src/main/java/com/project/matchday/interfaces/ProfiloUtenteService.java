package interfaces;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.project.matchday.Utente;
import com.project.matchday.model.Schedina;



@Service
public interface ProfiloUtenteService {
	

	ArrayList<Schedina> visualizzaSchedine(String email);
    Utente visualizzaProfilo();
	void giocaSchedina(Schedina schedina);
	void preleva(String email, Double importo);
	void deposita(String email, Double importo);
	

}
