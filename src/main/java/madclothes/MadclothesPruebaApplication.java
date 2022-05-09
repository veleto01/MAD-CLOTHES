package madclothes;

import java.security.SecureRandom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;

@SpringBootApplication
@EnableHazelcastHttpSession
public class MadclothesPruebaApplication {
	public static final String CACHE_USUARIOS="usuarios";
	public static final String CACHE_PRODUCTOS="productos";
	public static final String CACHE_OFERTA="ofetas";

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
	
	@Bean
	public CacheManager cacheManager() {
		final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
		LOGGER.info("Activating cache...");
		return new ConcurrentMapCacheManager("usuarios","productos");
	}
}
