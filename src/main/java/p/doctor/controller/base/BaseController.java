package p.doctor.controller.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import p.doctor.dto.base.JsonResult;


public class BaseController {
//    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    protected static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    protected <T> JsonResult<T> success(String msg){
        return newResult(true,msg,null);
    }
    protected <T> JsonResult<T> success(T data){
        return newResult(true,"",data);
    }
    protected <T> JsonResult<T> success(String msg, T data){
        return newResult(true,msg,data);
    }
    protected <T> JsonResult<T> error(String msg){
        return newResult(false,msg,null);
    }

    private <T> JsonResult<T> newResult(boolean success, String msg, T data){
        JsonResult<T> result = new JsonResult<>();
        result.setData(data);
        result.setSuccess(success);
        result.setMsg(msg);
        return result;
    }
}
