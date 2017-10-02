package com.spring.app.Oauth.Controller.web;

import java.util.List;
import javax.inject.Inject;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.CursoredList;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class OauthController {

	private Twitter twitter;

	private ConnectionRepository connectionRepository;

	@Inject
	public OauthController(Twitter twitter, ConnectionRepository connectionRepository) {
		this.twitter = twitter;
		this.connectionRepository = connectionRepository;
	}

	@GetMapping("/login")
	public String login(Model model) {
		return "redirect:/connect/twitter";
	}

	@GetMapping("/")
	public String hello(Model model) {
		//このページをログイン後にするための設定をしたい
		if (connectionRepository.findPrimaryConnection(Twitter.class) == null) {
			return "redirect:/login";
		}
		CursoredList<TwitterProfile> friends = twitter.friendOperations().getFriends();
		List<Tweet> tweets = twitter.timelineOperations().getHomeTimeline();
		model.addAttribute(twitter.userOperations().getUserProfile());
		model.addAttribute("friends", friends);
		model.addAttribute("tweets",tweets);
		return "main";
	}
	@GetMapping("/logout")
	public String logout() {
		connectionRepository.removeConnections("twitter");
		return "logout";
	}
}
