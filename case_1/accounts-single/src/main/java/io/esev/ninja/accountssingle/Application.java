package io.esev.ninja.accountssingle;

import io.esev.ninja.accountssingle.domain.Account;
import io.esev.ninja.accountssingle.domain.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

	@Autowired
	@Qualifier("localNewTransaction")
	private MessageChannel inputChannel;

	@Autowired
	@Qualifier("newTransaction")
	private PollableChannel outputChannel;

	public static void main(String[] args) {
		 SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner run(ApplicationContext context) {

		return args -> {
			inputChannel = context.getBean("localNewTransaction", MessageChannel.class);
			outputChannel = context.getBean("newTransaction", PollableChannel.class);

			inputChannel.send(new GenericMessage<>(new Transaction("011-1223-23432432-34", "011-3232-3556577567-23", 1230.5)));
			inputChannel.send(new GenericMessage<>(new Transaction("011-5435-87687687-32", "011-7657-7808786433-76", 200)));

			Object result = ((PollableChannel) outputChannel).receive().getPayload();
			Object result1 = ((PollableChannel) outputChannel).receive().getPayload();

			LOGGER.info("Resultado: {}", result);
			LOGGER.info("Resultado: {}", result1);

		};
	}

}
