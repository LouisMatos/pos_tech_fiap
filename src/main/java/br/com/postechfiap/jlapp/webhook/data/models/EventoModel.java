package br.com.postechfiap.jlapp.webhook.data.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "eventos")
public class EventoModel implements Serializable {

	private static final long serialVersionUID = -8920249848735316255L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_evento")
	private Long id;
	
	private String idNotificacao;

	private String tipoEvento;

	private String dataEvento;

	private String idWebhook;
	
}
