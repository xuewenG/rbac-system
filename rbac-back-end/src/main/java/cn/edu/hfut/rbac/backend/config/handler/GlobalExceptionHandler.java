package cn.edu.hfut.rbac.backend.config.handler;

import cn.edu.hfut.rbac.backend.constant.code.GlobalResponseCode;
import cn.edu.hfut.rbac.backend.exception.BaseException;
import cn.edu.hfut.rbac.backend.util.ResultUtil;
import cn.edu.hfut.rbac.backend.util.bean.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 葛学文
 * @date 2019/8/14 20:59
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * TODO 完善此方法
     */
    public static String getLog(Exception e, HttpServletRequest httpServletRequest) {
//        String userID = httpServletRequest.getRemoteUser();
//        String body = RequestUtil.getBody(httpServletRequest);
//        String url = httpServletRequest.getRequestURL().toString();
//        String log = e.getMessage() + "\n" +
//                "url: " +  url + "\n" +
//                "userID: " + userID + "\n" +
//                "request body: " + body;
//        return log;
        return "Log Not Available";
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    Message handleException(Exception e, HttpServletRequest httpServletRequest) {
        LOGGER.error(getLog(e, httpServletRequest));
        LOGGER.error(e.getMessage(), e);
        return ResultUtil.error();
    }

    @ExceptionHandler(BaseException.class)
    @ResponseBody
    Message handleBusinessException(BaseException e, HttpServletRequest httpServletRequest) {
        LOGGER.error(getLog(e, httpServletRequest));
        LOGGER.error(e.getMessage(), e);
        return ResultUtil.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    Message handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e, HttpServletRequest httpServletRequest) {
        LOGGER.error(getLog(new BaseException("不支持的 HTTP 方法"), httpServletRequest));
        LOGGER.error(e.getMessage(), e);
        return ResultUtil.error("不支持的 HTTP 方法");
    }

    @ExceptionHandler(DataAccessException.class)
    @ResponseBody
    Message handleDatabaseException(DataAccessException e, HttpServletRequest httpServletRequest) {
        LOGGER.error(getLog(new BaseException("数据库操作错误"), httpServletRequest));
        LOGGER.error(e.getMessage(), e);
        return ResultUtil.error("数据库操作错误");
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    Message handleHttpMessageNotReadableException(HttpMessageNotReadableException e, HttpServletRequest httpServletRequest) {
        LOGGER.error(getLog(new BaseException("请求体不可读"), httpServletRequest));
        LOGGER.error(e.getMessage(), e);
        return ResultUtil.error("请求体不可读");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    Message handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest httpServletRequest) {
        LOGGER.error(getLog(new BaseException("缺少参数"), httpServletRequest));
        LOGGER.error(e.getMessage(), e);
        return ResultUtil.error(GlobalResponseCode.INVALID_PARAMS, e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }
}
