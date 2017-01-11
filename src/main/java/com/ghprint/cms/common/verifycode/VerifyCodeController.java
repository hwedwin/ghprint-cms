package com.ghprint.cms.common.verifycode;


import com.ghprint.cms.common.util.CommonConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.RenderedImage;
import java.io.IOException;

/**
 * 
 * @ClassName: VerifyCodeController
 * @Description: 验证码
 * @author Tangyinbo
 * @date 2013-12-19 下午1:48:56
 * 
 */
@Controller
public class VerifyCodeController {
	/**
	 * 验证码产生工具类
	 */
	private IVerifyCodeBuilder vCodeBuilder = new VCodeBuilder();

	/**
	 * 
	 * @Title: getCode
	 * @Description: 验证码图片生成连接
	 * @param @param req
	 * @param @param resp
	 * @param @throws IOException
	 * @return void
	 * @author Tangyinbo
	 * @throws
	 */
	@RequestMapping(value = "/app/verify/getVerifyCode")
	public void getCode(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expires", 0);
		resp.setContentType("image/jpeg");

		HttpSession session = req.getSession();

		VerifyCode vCode = vCodeBuilder.generate();
		session.setAttribute(CommonConstant.LOGIN_VERIFY_CODE, vCode.getValue());

		ImageIO.write((RenderedImage) vCode.getImage(), "jpeg", resp.getOutputStream());
		resp.getOutputStream().flush();
	}
}
