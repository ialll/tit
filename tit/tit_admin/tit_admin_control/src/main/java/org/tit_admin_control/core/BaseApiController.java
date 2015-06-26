package org.tit_admin_control.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.tit_admin_common.core.ExceptionHandlerAdvice;
import org.tit_admin_common.core.Message;
import org.tit_admin_common.core.Props;
import org.tit_admin_common.core.Response;
import javax.servlet.http.HttpServletRequest;
import org.tit_admin_control.core.BaseController;;

/**
 * Base API controller to provide basic functionality
 * to the extending classes to handle exceptions
 * and render responses
 * @author 刘晓勇
 *
 */
public class BaseApiController extends BaseController {
    protected @Autowired ExceptionHandlerAdvice exceptionHandlerAdvice;
    protected @Autowired HttpServletRequest request;
    protected @Autowired Message msg;
    protected @Autowired Props props;
    private Logger log = LoggerFactory.getLogger(BaseApiController.class);


    protected Response serverResponse() {
        Response response = new Response();
        exceptionHandlerAdvice.setResponse(response);
        return response;
    }


    protected ModelAndView mav() {
        return new ModelAndView();
    }

    @ExceptionHandler(Exception.class)
    public @ResponseBody ModelAndView exceptionHandler(Exception ex) {
        Response response = new Response();
        response.setError(500, ex.getMessage());
        log.error("Response: " + response.toString());
        return mav().addObject("response", response);
    }
}
