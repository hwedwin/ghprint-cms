package com.ghprint.cms.common.verifycode;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 * 
* @ClassName: VCodeBuilder
* @Description: 验证码产生类
* @author Tangyinbo
* @date 2013-12-19 下午1:49:13
*
 */
public class VCodeBuilder implements IVerifyCodeBuilder {
	
	private static final Log LOG = LogFactory.getLog(VCodeBuilder.class);
	
	private int width = 70;									// 验证码图片的宽度

	private int height = 30;								// 验证码图片的高度

	private int codeCount = 4;								// 验证码字符个数

	public static final int MIXED_LINE_COUNT = 20; 			// 干扰线的数量
	
	public static final int GAP = 8;
	
	private static final char[] CHAR_SEQ = {
		'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
		'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
		'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
	};
	
	public VCodeBuilder() {
	}
	
	public VerifyCode generate() {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = image.createGraphics();
		
		g2d.setColor(Color.WHITE);										// 将图像填充为白色
		g2d.fill(new Rectangle2D.Double(0, 0, width, height));
		
		g2d.setFont(new Font("Fixedsys", Font.PLAIN, height - 2));		// 设置字体，字体的大小应该根据图片的高度来定
		g2d.setColor(Color.BLACK);
		g2d.draw(new Rectangle2D.Double(0, 0, width - 1, height - 1));
		
		// 随机产生干扰线，使图象中的认证码不易被其它程序探测到
		for (int i = 0; i < MIXED_LINE_COUNT; i++) {
			int startX = randInRange(0, width);
			int startY = randInRange(0, height);
			
			int endX = randInRange(0, width);
			int endY = randInRange(0, height);
			
			g2d.setColor(new Color(randInRange(0, 255), randInRange(0, 255), randInRange(0, 255)));
			g2d.drawLine(startX, startY, endX, endY);
		}
		
		g2d.setColor(Color.BLACK);
		char[] vCode = new char[codeCount];			// vCode - 随即生成的验证码
		int charWidth = width / (codeCount + 1);
		for (int i = 0; i < codeCount; i++) {
			vCode[i] = getNextChar();
			g2d.drawString("" + vCode[i], i * charWidth + GAP, height - 4);
		}
		
		VerifyCode result = new VerifyCode(String.valueOf(vCode), image);
		LOG.info("[generate]: Verify code created - " + result.getValue());
		
		return result;
	}
	
	public static char getNextChar() {
		return CHAR_SEQ[randInRange(0, CHAR_SEQ.length)];
	}
	
	public static int randInRange(int x, int y) {
		return x + (int)(Math.random() * (y - x));
	}
	
	public static double randInRange(double x, double y) {
		return x + Math.random() * (y - x);
	}
}

