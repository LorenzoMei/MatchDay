package com.project.matchday.interfaces;

import java.util.ArrayList;

import com.project.matchday.model.Evento;

public interface HomeService {
	
	ArrayList<Evento> visualizzaEventiPerTipo(String tipo);
}
