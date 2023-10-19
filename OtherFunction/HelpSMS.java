package OtherFunction;

import com.twilio.Twilio;
import com.twilio.converter.Promoter;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class HelpSMS {
	private static final String ACCOUNT_SID = "ACc2d1b4095a8ea915aaa722902a21bbee";
	private static final String AUTH_TOKEN = "93b1c55289415dd682878048ce5ff737";
	private static final String myPhone = "+15177438423";

	public static void createMessage(String phone, String your_message) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		Message message = Message
				.creator(new com.twilio.type.PhoneNumber(phone), new com.twilio.type.PhoneNumber(myPhone), your_message)
				.create();
		System.out.println(message);
	}
}
