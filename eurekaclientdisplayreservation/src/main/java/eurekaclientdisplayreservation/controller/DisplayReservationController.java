package eurekaclientdisplayreservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DisplayReservationController {
	@RequestMapping(value = "/displayReservation", method = RequestMethod.GET)
	public @ResponseBody String displayReservation(ModelMap model) {

		String reservation = "R9YTRK";
		StringBuffer buffer = new StringBuffer();

		buffer.append("---------reservation display start---------");
		buffer.append("\n");
		buffer.append(reservation);
		buffer.append("\n");
		buffer.append("---------reservation display end---------");
		buffer.append("\n");
		return buffer.toString();
	}
}
