package com.skt.SpringAi.BusinessLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skt.SpringAi.Request.EncryptedRequest;
import com.skt.SpringAi.Response.EncryptedResponse;
import com.skt.SpringAi.Util.AESCipherService;

@Component
public class BusinessLogic {

	@Autowired
	AESCipherService aes;
	
	public EncryptedResponse encryptRequest(EncryptedRequest request) throws Exception {
		
		EncryptedResponse response = new EncryptedResponse();
		
		String dcrptPan = aes.encrypt(request.getPanNumber());
		response.setPanNumber(dcrptPan);
		return response;
	}

	public EncryptedResponse decryptRequest(EncryptedRequest request) throws Exception {

		EncryptedResponse response = new EncryptedResponse();
		String panNo = aes.decrypt(request.getPanNumber());
		response.setPanNumber(panNo);
		return response;
	}

	
}
