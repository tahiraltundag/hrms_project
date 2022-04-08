package kodlamaio.hrms.core.utilities.verification.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;

public interface MailVerificationService {
	void sendEmail(String email);     //E-posta gonder
	Result verifyEmail(String email);   //Email i dogrula
}
