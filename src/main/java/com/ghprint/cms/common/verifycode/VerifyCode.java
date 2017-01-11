package com.ghprint.cms.common.verifycode;

import java.awt.*;

/**
 * 
* @ClassName: VerifyCode
* @Description: 验证码实体类
* @author Tangyinbo
* @date 2013-12-19 下午1:49:27
*
 */
public class VerifyCode {
	
	/**
	 * 
	 */

	private String value;

	private Image image;

	private long expiresTimeMillis;
	
	// 默认过期时间：10分钟
	public static final int DEFAULT_EXPIRES_INTERVAL = 10 * 60;
	
	public VerifyCode(String _value, Image _image) {
		this.value = _value;
		this.image = _image;
		this.setExpiresTimeAfter(DEFAULT_EXPIRES_INTERVAL);
	}
	
	/**
	 * 设置过期时间间隔，单位：秒
	 */
	public void setExpiresTimeAfter(int seconds) {
		this.expiresTimeMillis = System.currentTimeMillis() + seconds * 1000;
	}
	
	public boolean isExpired() {
		return (this.expiresTimeMillis < System.currentTimeMillis());
	}

	public long getExpiresTimeMillis() {
		return expiresTimeMillis;
	}

	public void setExpiresTimeMillis(long expiresTimeMillis) {
		this.expiresTimeMillis = expiresTimeMillis;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
