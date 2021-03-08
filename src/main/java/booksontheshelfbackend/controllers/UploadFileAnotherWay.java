package booksontheshelfbackend.controllers;

import booksontheshelfbackend.entities.FormDataWithFile;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin("*")
@RestController
@RequestMapping("/botsab")
public class UploadFileAnotherWay {

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String submitFile(@RequestParam("file") MultipartFile file, ModelMap modelMap) {
        modelMap.addAttribute("file", file);
        return "fileUploadView";
    }

    @RequestMapping(value = "/uploadMultiFile", method = RequestMethod.POST)
    public String submitMultiFile(@RequestParam("files") MultipartFile[] files, ModelMap modelMap) {
        modelMap.addAttribute("files", files);
        return "fileUploadView";
    }

    @PostMapping("/uploadFileWithAddtionalData")
    public String submitFileWithAddtionalData(
            @RequestParam MultipartFile file, @RequestParam String name,
            @RequestParam String email, ModelMap modelMap) {

        modelMap.addAttribute("name", name);
        modelMap.addAttribute("email", email);
        modelMap.addAttribute("file", file);
        return "fileUploadView";
    }

    @PostMapping("/uploadFileModelAttribute")
    public String submitileModelAttribute(@ModelAttribute FormDataWithFile formDataWithFile, ModelMap modelMap) {

        modelMap.addAttribute("formDataWithFile", formDataWithFile);
        return "fileUploadView";
    }
}
