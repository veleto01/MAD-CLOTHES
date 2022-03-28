package madclothes.entidades;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationServer {
	
	private static final String MAIL_SERVICE_URL = "http://localhost:8444";
	
	public static boolean enviarNotificacion (String direccionCorreo,String mensaje) {
		try {
			mensaje msg = new mensaje(direccionCorreo,"Bienvenido a MADCLOTHES", mensaje);

			HttpEntity<mensaje> httpEntity = new HttpEntity<>(msg);
			
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Void> res =restTemplate.postForEntity(MAIL_SERVICE_URL + "/notificacion", httpEntity, Void.class);

			if(res.getStatusCode() == HttpStatus.CREATED) {
				System.out.println("Enviado correctamente");
				return true;
			}else{
				System.out.println("Error enviando:"+res.getStatusCode());
				return false;
			}
		}catch (Exception e) {
			System.out.println("Error enviando:"+e.getMessage());
			e.printStackTrace();
			return false;
		}
		
	}
}
