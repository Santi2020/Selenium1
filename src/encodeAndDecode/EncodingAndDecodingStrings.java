package encodeAndDecode;

import java.awt.AWTException;

import org.apache.commons.codec.binary.Base64;

public class EncodingAndDecodingStrings {
	public static void  main(String[] args) throws AWTException, InterruptedException
	{
		//Encoding the srting
		String str ="admin";
		byte[] encodedstring = Base64.encodeBase64(str.getBytes());
		System.out.println("Encoded string =" + new String (encodedstring));
		
		//Decoding the string
		byte[] decodedstring = Base64.decodeBase64(encodedstring);
		System.out.println("Decoded string =" + new String (decodedstring));
	}
}


