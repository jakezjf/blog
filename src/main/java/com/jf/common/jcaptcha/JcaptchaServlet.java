package com.jf.common.jcaptcha;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.jf.common.session.SessionProvider;
import com.octo.captcha.service.CaptchaServiceException;
import com.octo.captcha.service.image.ImageCaptchaService;

/**
 * Created by JF on 2016/6/1.
 */

@SuppressWarnings("serial")
public class JcaptchaServlet extends HttpServlet {

    public static final String CAPTCHA_IMAGE_FORMAT = "jpeg";

    private ImageCaptchaService captchaService;

    private SessionProvider session;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("sadasdsadasdsaadasdasdasdad");
        byte[] captchaChallengeAsJpeg = null;
        // the output stream to render the captcha image as jpeg into
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            // get the session id that will identify the generated captcha.
            // the same id must be used to validate the response, the session id
            // is a good candidate!

            String captchaId = this.session.getSessionId(request, response);
            BufferedImage challenge = this.captchaService.getImageChallengeForID(captchaId, request.getLocale());
            // Jimi.putImage("image/jpeg", challenge, jpegOutputStream);
            ImageIO.write(challenge, JcaptchaServlet.CAPTCHA_IMAGE_FORMAT, jpegOutputStream);
        }
        catch (IllegalArgumentException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        catch (CaptchaServiceException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }
        // catch (JimiException e) {
        // response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        // return;
        // }

        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();

        // flush it in the response
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/" + JcaptchaServlet.CAPTCHA_IMAGE_FORMAT);

        ServletOutputStream responseOutputStream = response.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }

    @Override
    public void init() throws ServletException {
        WebApplicationContext appCtx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        this.captchaService = BeanFactoryUtils.beanOfTypeIncludingAncestors(appCtx, ImageCaptchaService.class);
        this.session = BeanFactoryUtils.beanOfTypeIncludingAncestors(appCtx, SessionProvider.class);
    }
}
