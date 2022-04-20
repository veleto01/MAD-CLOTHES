package madclothes.servicioInterno;


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
 
        //store the user and its email in an arraylist
        List<String> data = new ArrayList<>(2);
        data.add(direccion);
        data.add(email);

        //code needed to send the arraylist so the rest controller can recibe it on the body
        HttpEntity<List> requestEntity = getListHttpEntity(data);
        //sends the information in a post to the Rest
        restTemplate.postForEntity("http://localhost:8444/email", requestEntity, String.class);
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