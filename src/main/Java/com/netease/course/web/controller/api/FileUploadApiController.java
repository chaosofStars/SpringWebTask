package com.netease.course.web.controller.api;



import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpSession;
import java.io.*;
import java.sql.Date;


@Controller
@RequestMapping("/api")
public class FileUploadApiController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap upload(@RequestParam("file") MultipartFile file, ModelMap modelMap,
                           HttpSession httpSession) throws IOException {
        if (!file.isEmpty()) {

            //获取文件的路径
            String filePath = httpSession.getServletContext().getRealPath(File.separator) + "images";
            String fileName = new Date(System.currentTimeMillis()).getTime()+ file.getOriginalFilename();
            System.out.println("fileName:"+ fileName);
            System.out.println("filePath:"+ filePath);

            File tempFile = new File(filePath, fileName);
            if (!tempFile.getParentFile().exists()) {
                tempFile.getParentFile().mkdir();
            }
            if (!tempFile.exists()) {
                tempFile.createNewFile();
            }
            file.transferTo(tempFile);

            modelMap.addAttribute("code", 200);
            modelMap.addAttribute("message", "success");
            modelMap.addAttribute("result", File.separator+"images"+File.separator+fileName);
        } else {
            System.out.println(file);
            modelMap.addAttribute("code", 400);
            modelMap.addAttribute("message", "failed");
            modelMap.addAttribute("result", null);
        }
        return modelMap;
    }
}

