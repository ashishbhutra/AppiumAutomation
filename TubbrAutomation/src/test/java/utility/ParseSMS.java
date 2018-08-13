package utility;

public class ParseSMS {
	
	public static String getSMS(String msgString){
		String[] msgArr = msgString.split(" ");
		int msgLen = msgArr.length;
		System.out.println(msgLen);
		System.out.println(msgArr[msgLen-1]);
		return msgArr[msgLen-1];
	}
	
	
	public static String[] getOTP(String sms){
		
		String[] otp = null;
		String word = getSMS(sms);
		System.out.println(word);
		otp = word.split("");
		System.out.println(otp);
		return otp;
	}
}
