package org.tit_admin_common.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;


/**
 * @author 刘晓勇
 *
 */
@Component
@ImportResource(value="/WEB-INF/spring/appServlet/applicationContext-properties.xml")
public class HttpError{
	  // Common HTTP errors
    public @Value("#{heProps['br.msg']}") String brMsg;
    public @Value("#{heProps['br.code']}") int brCode;
    public @Value("#{heProps['ua.msg']}") String uaMsg;
    public @Value("#{heProps['ua.code']}") int uaCode;
    public @Value("#{heProps['nf.msg']}") String nfMsg;
    public @Value("#{heProps['nf.code']}") int nfCode;
    public @Value("#{heProps['mna.msg']}") String mnaMsg;
    public @Value("#{heProps['mna.code']}") int mnaCode;
    public @Value("#{heProps['rt.msg']}") String rtMsg;
    public @Value("#{heProps['rt.code']}") int rtCode;
    public @Value("#{heProps['umt.msg']}") String umtMsg;
    public @Value("#{heProps['umt.code']}") int umtCode;
    public @Value("#{heProps['ise.msg']}") String iseMsg;
    public @Value("#{heProps['ise.code']}") int iseCode;
    public @Value("#{heProps['ni.msg']}") String niMsg;
    public @Value("#{heProps['ni.code']}") int niCode;
    public @Value("#{heProps['su.msg']}") String suMsg;
    public @Value("#{heProps['su.code']}") int suCode;
}

