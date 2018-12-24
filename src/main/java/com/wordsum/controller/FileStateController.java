package com.wordsum.controller;

import com.wordsum.process.read.models.text.FileState;
import com.wordsum.service.FileStateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class FileStateController {

    private static Logger logger = LoggerFactory.getLogger(FileStateController.class);

    private final FileStateService fileStateService;


    @Autowired
    public FileStateController(FileStateService fileStateService) {
        this.fileStateService = fileStateService;
    }

    @RequestMapping(value = "/filestate", method = RequestMethod.POST)
    @ResponseBody
    public FileState filestate(@RequestPart(required=false) FileState fileState,
                               @RequestPart("file") MultipartFile file,
                            RedirectAttributes redirectAttributes) throws Exception {

        logger.info("Processing the file: " + file.getOriginalFilename());
        fileState = fileStateService.processTxt(fileState, file);

        return fileState;
    }


}
