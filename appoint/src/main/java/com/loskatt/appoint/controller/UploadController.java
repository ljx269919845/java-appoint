package com.loskatt.appoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.loskatt.appoint.common.Result;
import com.loskatt.appoint.common.StatusCode;
import com.loskatt.appoint.service.FileObjService;

@Controller
@RequestMapping("medical")
public class UploadController {	
	@Autowired
	private FileObjService fileObjService;

    /**
     * 上传文件方法
     * @param file 前台上传的文件对象
     * @return
     */
    @RequestMapping(value = "/upload/single",method = RequestMethod.POST)
    public @ResponseBody Result upload(MultipartFile file){
        try {
        	 return fileObjService.upload(file);
        }catch (Exception e){
            e.printStackTrace();
            return new Result<String>(StatusCode.UNKNOW_RESULT,e.getLocalizedMessage());
        }
    }

    /**
     * 上传多个文件
     * @param request 请求对象
     * @param file 上传文件集合
     * @return
     */
    @RequestMapping(value = "/upload/multi",method = RequestMethod.POST)
    public @ResponseBody Result uploads(MultipartFile[] files){
        try {
            for (int i =0;i<files.length;i++) {
                if(files[i] != null) {
                	fileObjService.upload(files[i]);
                }
            }
        }catch (Exception e){
            //打印错误堆栈信息
            return new Result<String>(StatusCode.UNKNOW_RESULT,e.getLocalizedMessage());
        }
        return new Result<String>(StatusCode.RESULT_SUCCESS);
    }
}
