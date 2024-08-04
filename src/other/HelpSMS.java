package other;

import com.twilio.Twilio;
import com.twilio.converter.Promoter;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class HelpSMS {
	private static final String ACCOUNT_SID = "AC715592f9adf87d6eee465fafe7d2d20f";
	private static final String AUTH_TOKEN = "73cf1df7bc7ce096564dc1dcbf70eab8";
	private static final String myPhone = "+12053081496";

	public static void createMessage(String phone, String your_message) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		Message message = Message
				.creator(new com.twilio.type.PhoneNumber(phone), new com.twilio.type.PhoneNumber(myPhone), your_message)
				.create();
		System.out.println(message);
	}
	
}
