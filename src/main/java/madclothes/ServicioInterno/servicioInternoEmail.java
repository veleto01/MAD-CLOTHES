package madclothes.ServicioInterno;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;




public class servicioInternoEmail {
    @Async
    public void sendRegisterEmail(String direccion, String email) throws RestClientException, URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        URI url = new URI("http://localhost:8080/emails/registration-email/");
        List<String> data = new ArrayList<>(2);
        data.add(direccion);
        data.add(email);
        HttpEntity<List> requestEntity = getListHttpEntity(data);
        restTemplate.postForEntity(url, requestEntity, String.class);
    }

    private HttpEntity<List> getListHttpEntity(List<String> data) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<List> requestEntity = new HttpEntity<>(data, headers);
        return requestEntity;
    }
}
