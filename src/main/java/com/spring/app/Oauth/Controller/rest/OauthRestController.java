package com.spring.app.Oauth.Controller.rest;

import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.social.twitter.api.Twitter;


@RestController
@RequestMapping("api/Oauth")
public class OauthRestController {

	private ConnectionRepository connectionRepository;

	@Inject
	public OauthRestController(ConnectionRepository connectionRepository) {
		this.connectionRepository = connectionRepository;
	}

	@GetMapping(value="/logout")
	public void logout(HttpServletResponse response) throws IOException{
		if (connectionRepository.findPrimaryConnection(Twitter.class) == null) {
			response.sendError(HttpStatus.NOT_FOUND.value(),"データが見つかりませんでした");
		}
		connectionRepository.removeConnections("twitter");
	}
}
