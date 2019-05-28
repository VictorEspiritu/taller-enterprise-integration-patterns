package io.esev.ninja.accountssingle;

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
@ImportResource("classpath:integration4.xml")
public class Application {

	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

	@Autowired
	@Qualifier("inTransaction")
	private MessageChannel inputChannel;

//	@Autowired
//	@Qualifier("outTransaction")
//	private PollableChannel outputChannel;

//	@Autowired
//	@Qualifier("processTransaction")
//	private PollableChannel outputChannel; //2

//	@Autowired
//	@Qualifier("validTransactionChannel")
//	private PollableChannel validTransactionChannel; //3

//	@Autowired
//	@Qualifier("invalidTransactionChannel")
//	private PollableChannel validTransactionChannel; //3

	@Autowired
	@Qualifier("endValidTransactionChannel")
	private PollableChannel validTransactionChannel; //4

	@Autowired
	@Qualifier("endInvalidTransactionChannel")
	private PollableChannel invalidTransactionChannel; //4

	public static void main(String[] args) {
		 SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner run(ApplicationContext context) {

		return args -> {

			LOGGER.info("*****************[0]  Envio del primer mensaje");
			inputChannel.send(new GenericMessage<>(new Transaction("1","011-0760-0200374154", "011-0760-0564423422", 2230.5)));
			LOGGER.info("*****************[0] Envio del segundo mensaje");
			inputChannel.send(new GenericMessage<>(new Transaction("2","011-0199-0345345455", "011-0199-0766565454", 200)));

			LOGGER.info("*****************[3] Valid Messages to Process");
			Object result = ((PollableChannel) validTransactionChannel).receive().getPayload();
			LOGGER.info("Resultado1: {}", result);

			LOGGER.info("*****************[3] InValid Messages to Process");
			Object result1 = ((PollableChannel) invalidTransactionChannel).receive().getPayload();
			LOGGER.info("Resultado2: {}", result1);
		};
	}

}
