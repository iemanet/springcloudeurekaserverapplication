package eurekaclientreissue.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClientException;

import eurekaclientreissue.client.Client;

@Controller
public class ReissueController {

	@Autowired
	private Client client;

	@RequestMapping(value = "/reissue", method = RequestMethod.GET)
	public @ResponseBody String reissue(ModelMap model) throws RestClientException, IOException {

		StringBuffer buffer = new StringBuffer();

		buffer.append("---------reissue start---------");
		buffer.append("\n");

		String reservation = client.displayReservation();

		buffer.append(reservation);
		buffer.append("\n");
		buffer.append("---------reissue end---------");
		return buffer.toString();
	}
}
