package api;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import beans.Prospect;
import controllers.SubscribeController;
@RestController
public class SubscribeAPI {
	private String downloadLink="Download link here";
	
	@Autowired
	private SubscribeController subscribeController;
	
	@RequestMapping(value="/leads/subscribe", method=RequestMethod.POST, consumes="application/json")
	public void subscribe(@RequestBody Prospect prospect, HttpServletResponse res)throws Exception{
		this.subscribeController.createSubscriber(prospect);
		downloadAttachment(res);
	}

	private void downloadAttachment(HttpServletResponse res) throws IOException {
		res.setContentType("application/pdf");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		res.addHeader("Content-Disposition", "attachment; "+downloadLink);
		OutputStream os = res.getOutputStream();
		baos.writeTo(os);
		os.flush();
		os.close();
	}
}
