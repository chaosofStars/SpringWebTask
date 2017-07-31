package com.netease.course.web.controller.api;


import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;


@Controller
@RequestMapping("/api")
public class FileUploadApiController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap upload(@RequestParam("file") MultipartFile file, ModelMap modelMap,
                           HttpSession httpSession) throws IOException {
        if (!file.isEmpty()) {
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
            //获取文件的路径
            String filePath = httpSession.getServletContext().getRealPath("/") + "image";
            File copyFile = new File(filePath, fileName);
            FileUtils.copyInputStreamToFile(file.getInputStream(), copyFile);
            modelMap.addAttribute("code", 200);
            modelMap.addAttribute("message", "success");
            modelMap.addAttribute("result", "/image/"+fileName);
        } else {
            modelMap.addAttribute("code", 400);
            modelMap.addAttribute("message", "failed");
            modelMap.addAttribute("result", null);
        }
        return modelMap;
    }
}

