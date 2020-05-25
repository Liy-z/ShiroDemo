package cn.shiro.util;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import cn.shiro.extity.User;

public class PasswordHelper {
	private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
	private String algorithmName = "md5";
	private int hashIterations = 2;

	public void encryptPassword(User user) {
		String salt=randomNumberGenerator.nextBytes().toHex();
		user.setCredentialsSalt(salt);
		//userFormMap.put("credentialsSalt", salt);
		String newPassword = new SimpleHash(algorithmName, user.getPassword(), ByteSource.Util.bytes(user.getAccountName()+salt), hashIterations).toHex();
		user.setPassword(newPassword);
		//userFormMap.put("password", newPassword); 
	}
	public static void main(String[] args) {
		PasswordHelper passwordHelper = new PasswordHelper();
		User user = new User();
		/*userFormMap.put("password","123456");
		userFormMap.put("accountName","admin");*/
		user.setPassword("123456");
		user.setAccountName("admin");
		passwordHelper.encryptPassword(user);
		System.out.println(user);
	}
}
