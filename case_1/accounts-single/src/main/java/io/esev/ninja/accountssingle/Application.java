package io.esev.ninja.accountssingle;

import io.esev.ninja.accountssingle.domain.Account;
import io.esev.ninja.accountssingle.domain.Transaction;
import io.esev.ninja.accountssingle.service.AccountService;
import io.esev.ninja.accountssingle.service.CustomerService;
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
	private AccountService accountService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	@Qualifier("inTransaction")
	private MessageChannel inputChannel;

	@Autowired
	@Qualifier("outTransaction")
	private PollableChannel outputChannel;

	public static void main(String[] args) {
		 SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner run(ApplicationContext context) {

		return args -> {

			inputChannel.send(new GenericMessage<>(new Transaction("1","011-0760-0200374154", "011-0760-0564423422", 1230.5)));
			inputChannel.send(new GenericMessage<>(new Transaction("2","011-0199-0345345455", "011-0199-0766565454", 200)));

			Object result = ((PollableChannel) outputChannel).receive().getPayload();
			Object result1 = ((PollableChannel) outputChannel).receive().getPayload();

			LOGGER.info("Resultado: {}", result);
			LOGGER.info("Resultado: {}", result1);
		};
	}

}
