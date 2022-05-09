package madclothes;

import java.security.SecureRandom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;

@SpringBootApplication
@EnableHazelcastHttpSession
public class MadclothesPruebaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MadclothesPruebaApplication.class, args);
	}

	@Bean
	public Config config() {
		
		Config config = new Config();
		JoinConfig joinConfig = config.getNetworkConfig().getJoin();
		
		joinConfig.getMulticastConfig().setEnabled(true);
		//joinConfig.getTcpIpConfig().setEnabled(true).setMembers(Collections.singletonList(environment.getProperty("217.71.204.219")));
		
		return config;
	}
}
