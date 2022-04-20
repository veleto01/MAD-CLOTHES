package madclothes.servicioInterno;

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
	  /**
     * Asks the Rest to send an email when the user correctly registers
     *
     * @param username user username
     * @param email    user email
     * @throws RestClientException
     * @throws URISyntaxException
     */
    @Async
    public void sendRegisterEmail(String direccion, String email) throws RestClientException, URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        //URL of the controller in charge of sending the emails
        URI url = new URI("http://localhost:8080/emails/registration-email/");
        //store the user and its email in an arraylist
        List<String> data = new ArrayList<>(2);
        data.add(direccion);
        data.add(email);

        //code needed to send the arraylist so the rest controller can recibe it on the body
        HttpEntity<List> requestEntity = getListHttpEntity(data);
        //sends the information in a post to the Rest
        restTemplate.postForEntity(url, requestEntity, String.class);
    }





    /**
     * Auxiliar method for packaging the information we need to send to the REST
     *
     * @param data information that needs to be sent to the REST
     * @return an http entity with the information
     */
    private HttpEntity<List> getListHttpEntity(List<String> data) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<List> requestEntity = new HttpEntity<>(data, headers);
        return requestEntity;
    }
}