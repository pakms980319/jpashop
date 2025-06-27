package jpabook.jpashop;

import com.fasterxml.jackson.datatype.hibernate5.jakarta.Hibernate5JakartaModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpashopApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(JpashopApplication.class, args);
	}

	@Bean
	public Hibernate5JakartaModule hibernate5JakartaModule() {
		Hibernate5JakartaModule module = new Hibernate5JakartaModule();

		// 필요하면 지연 로딩 강제 설정도 가능
//		module.configure(Hibernate5JakartaModule.Feature.FORCE_LAZY_LOADING, true);
		return module;
	}
}
