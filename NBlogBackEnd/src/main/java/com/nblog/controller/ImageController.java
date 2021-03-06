package com.nblog.controller;

import com.nblog.annotation.LogAnnotation;
import com.nblog.dto.Result;
import com.nblog.service.ImageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.nblog.constant.OptTypeConst.REMOVE;
import static com.nblog.constant.OptTypeConst.UPLOAD;

/**
 * 与图片处理有关的操作
 */

@RestController
@RequestMapping("/image")
@Api(tags = "图片模块")
public class ImageController {
    /**
     * Spring IOC 自动注入 ImageService 实例
     * 使用 Setter的方式注入，更加具有可变性
     */
    private ImageService imageService;

    @Autowired
    public void setService(ImageService imageService) {
        this.imageService = imageService;
    }

    /**
     * 图片上传
     * @param file 图片
     * @return result
     */
    @PostMapping("/upload")
    @ApiOperation(value = "图片上传")
    @LogAnnotation(optType = UPLOAD)
    public Result<String> upload(@RequestParam("file") String file){
        return imageService.upload(file);
    }

    /**
     * 图片删除
     * @param path 路径
     * @return result
     */
    @DeleteMapping("/del")
    @ApiOperation(value = "图片删除")
    @LogAnnotation(optType = REMOVE)
    public Result<Boolean> delImg(@RequestParam("path") String path){
        return imageService.del(path);
    }
}
