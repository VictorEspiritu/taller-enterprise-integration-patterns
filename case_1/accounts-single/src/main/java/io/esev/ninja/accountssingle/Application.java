package io.esev.ninja.accountssingle;

import io.esev.ninja.accountssingle.domain.AccountTransfer;
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

	//0, 1, 2
	@Autowired
	@Qualifier("newTransferChannel")
	private MessageChannel newTransferChannel;
	@Autowired
	@Qualifier("outputTransferChannel")
	private PollableChannel outputTransferChannel;

	//3,4
//	@Autowired
//	@Qualifier("outputValidTransferChannel")
//	private MessageChannel outputValidTransferChannel;
//	@Autowired
//	@Qualifier("outputInvalidTransferChannel")
//	private PollableChannel outputInvalidTransferChannel;

	public static void main(String[] args) {
		 SpringApplication.run(Application.class, args);
	}

	//0, 1, 2
	@Bean
	public CommandLineRunner run(ApplicationContext context) {

		return args -> {

			LOGGER.info("*****************[0]  Primera Transferencia");
			newTransferChannel.send(
					new GenericMessage<>(
							new AccountTransfer(
									"1",
									"012-0760-0200374154",
									"016-0760-0564423422",
									2230.5)
					)
			);

			LOGGER.info("*****************[0] Segunda Transferencia");
			newTransferChannel.send(
					new GenericMessage<>(
							new AccountTransfer(
									"2",
									"015-0199-0345345455",
									"014-0199-0766565454",
									200)
					)
			);


			Object result = ((PollableChannel) outputTransferChannel).receive().getPayload();
			LOGGER.info("****************[3] Resultado0: {}", result);

			Object result1 = ((PollableChannel) outputTransferChannel).receive().getPayload();
			LOGGER.info("****************[3] Resultado1: {}", result1);

		};
	}

	//3,4
//	@Bean
//	public CommandLineRunner run(ApplicationContext context) {
//
//		return args -> {
//
//			LOGGER.info("*****************[0]  Primera Transferencia");
//			newTransferChannel.send(
//					new GenericMessage<>(
//							new AccountTransfer(
//									"1",
//									"012-0760-0200374154",
//									"016-0760-0564423422",
//									2230.5)
//					)
//			);
//
//			LOGGER.info("*****************[0] Segunda Transferencia");
//			newTransferChannel.send(
//					new GenericMessage<>(
//							new AccountTransfer(
//									"2",
//									"015-0199-0345345455",
//									"014-0199-0766565454",
//									200)
//					)
//			);
//
//			Object resultValid = ((PollableChannel) outputValidTransferChannel).receive().getPayload();
//			Object resultInValid = ((PollableChannel) outputInvalidTransferChannel).receive().getPayload();
//			LOGGER.info("****************[3] Resultado0-v: {}", resultValid);
//			LOGGER.info("****************[3] Resultado0-i: {}", resultInValid);
//
//			Object result1Valid = ((PollableChannel) outputValidTransferChannel).receive().getPayload();
//			Object result1InValid = ((PollableChannel) outputValidTransferChannel).receive().getPayload();
//			LOGGER.info("****************[3] Resultado1-v: {}", result1Valid);
//			LOGGER.info("****************[3] Resultado1-i: {}", result1InValid);
//
//		};
//	}

}
