package com.virtusa.chatbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.virtusa.chatbot.config.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)

public class ChatbotApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatbotApplication.class, args);
	}

}
