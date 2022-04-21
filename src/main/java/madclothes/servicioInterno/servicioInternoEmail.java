package madclothes.servicioInterno;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import madclothes.entidades.WebUser;




@Service
public class servicioInternoEmail {
private static final String MAIL_SERVICE_URL = "http://localhost:8444";
    public static boolean sendRegisterEmail(WebUser Usuario) {
        try {
            email Email = new email(Usuario.getCorreo(), "Registro MADCLOTHES","¡Gracias "+Usuario.getNombre()+" "+Usuario.getApellidos()+" por resgistrarte en MADCLOTHES, disfruta de nuestra tienda :)");
            HttpEntity<email> httpEntity = new HttpEntity<>(Email);
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Void> res =restTemplate.postForEntity(MAIL_SERVICE_URL+"/email", httpEntity, Void.class);

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
