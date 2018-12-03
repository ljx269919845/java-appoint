package com.loskatt.appoint.service.impl;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.loskatt.appoint.cache.Cache;
import com.loskatt.appoint.cache.CacheManager;
import com.loskatt.appoint.common.GlobalException;
import com.loskatt.appoint.common.Result;
import com.loskatt.appoint.common.StatusCode;
import com.loskatt.appoint.common.WechatAuthCodeResponse;
import com.loskatt.appoint.config.WechatAuthProperties;
import com.loskatt.appoint.mapper.UserMapper;
import com.loskatt.appoint.model.User;

@Service
public class WechatSupport {
	private static final Logger LOGGER = LoggerFactory.getLogger(WechatSupport.class);

    @Autowired
    private UserMapper userMapper;

    /**
     * 服务器第三方session有效时间，单位秒, 默认1天
     */
    private static final Long EXPIRES = 86400L;

    private RestTemplate wxAuthRestTemplate = new RestTemplate();

    @Autowired
    private WechatAuthProperties wechatAuthProperties;

    @Autowired
    private CacheManager cacheManager;

    public Result wechatLogin(String code) {
        WechatAuthCodeResponse response = getWxSession(code);
        if(response == null) {
    	    throw new GlobalException(StatusCode.USER_AUTH_WX_DATA_ERROR);
        }
        String wxOpenId = response.getOpenid();
        wxOpenId="test";
        //String wxSessionKey = response.getSessionKey();
        User userDB = userMapper.selectByOpenId(wxOpenId);
        if (null == userDB) {
        	User user = new User();
            user.setOpenId(wxOpenId);
            user.setUserName("init");
            user.setUserPhone("00000");
        	userMapper.insert(user);
        	return new Result<User>(StatusCode.RESULT_SUCCESS,user);
        }else {
        	return new Result<User>(StatusCode.RESULT_SUCCESS,userDB);
        }
        // Long expires = response.getExpiresIn();
        //String token = createSession(wxOpenId, wxSessionKey, expires);
        //return new Result<User>(StatusCode.RESULT_SUCCESS,user);
    }

    public WechatAuthCodeResponse getWxSession(String code) {
        String urlString = "?appid={appid}&secret={srcret}&js_code={code}&grant_type={grantType}";
        String response = wxAuthRestTemplate.getForObject( wechatAuthProperties.getSessionHost() + urlString, String.class,
                wechatAuthProperties.getAppId(),
                wechatAuthProperties.getSecret(),
                code,
                wechatAuthProperties.getGrantType());
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectReader reader = objectMapper.readerFor(WechatAuthCodeResponse.class);
        WechatAuthCodeResponse res;
        try {
            res = reader.readValue(response);
        } catch (IOException e) {
            res = null;
        }
/*        LOGGER.info(response);
        if (null == res) {
        	throw new GlobalException(StatusCode.USER_AUTH_WX_ERROR);
        }
        if (res.getErrcode() != null) {
            throw new RuntimeException(res.getErrmsg());
        }
        res.setExpiresIn(res.getExpiresIn() != null ? res.getExpiresIn() : EXPIRES);*/
        return res;
    }

    public String createSession(String wxOpenId, String wxSessionKey, Long expires) {
        String sessionKey = RandomStringUtils.randomAlphanumeric(64);
        StringBuffer sb = new StringBuffer();
        sb.append(wxSessionKey).append("#").append(wxOpenId);
        Cache cache = new Cache(sessionKey,sb,expires,false);
        cacheManager.putCache(sessionKey,cache);
        return sessionKey;
    }
}
