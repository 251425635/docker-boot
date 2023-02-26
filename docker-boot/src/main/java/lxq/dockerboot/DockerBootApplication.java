package lxq.dockerboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("lxq/dockerboot/mapper")
@EnableCaching
@SpringBootApplication
public class DockerBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerBootApplication.class, args);
	}

}
