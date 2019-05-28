package io.esev.ninja.accountssingle;

import io.esev.ninja.accountssingle.domain.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.GenericMessage;

@SpringBootApplication
@ImportResource("classpath:integration.xml")
public class Application {

	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		 SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner run(ApplicationContext context) {

		return args -> {
			MessageChannel inputChannel = context.getBean("localNewTransaction", MessageChannel.class);
			MessageChannel outputChannel = context.getBean("newTransaction", PollableChannel.class);

			Account account = new Account("011-1233-3231232-23", 2000.00, 1);
			inputChannel.send(new GenericMessage<>(account));
			Object result = ((PollableChannel) outputChannel).receive().getPayload();

			LOGGER.info("Resultado: {}", result);
		};
	}

}
