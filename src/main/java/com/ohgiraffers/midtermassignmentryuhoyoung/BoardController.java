package com.ohgiraffers.midtermassignmentryuhoyoung;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class BoardController {

    @PostMapping(value = {"/board/regist", "/board/regist/file"})
    public String handleFormSubmission(@ModelAttribute("board") com.ohgiraffers.midtermassignmentryuhoyoung.BoardDTO boardDTO,
                                       @ModelAttribute("singleFile") MultipartFile singleFile,
                                       String singleFileDescription, Model model) {

        System.out.println(boardDTO.toString());
        if (!singleFile.isEmpty()) {
            String root = "src/main/resources/static";
            String filePath = root + "/uploadFiles";
            File dir = new File(filePath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            String originFileName = singleFile.getOriginalFilename();
            System.out.println(originFileName);
            try {
//                File changeFile = new File(filePath + "/" + originFileName);
//                System.out.println(changeFile);
                Path path = Paths.get(filePath + "/" + originFileName).toAbsolutePath();
                singleFile.transferTo(path.toFile());
                model.addAttribute("message", "파일 업로드 성공");
                model.addAttribute("board", boardDTO);
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("message", "파일 업로드 실패");
            }
        }

        return "result";
    }



}
