package booksontheshelfbackend.controllers;

import booksontheshelfbackend.exceptions.UploadFileNotFoundException;
import booksontheshelfbackend.repositories.UploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.http.HttpHeaders;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/botsab")
public class UploadFileController {

    private final UploadRepository storageRepository;

    @Autowired
    public UploadFileController(UploadRepository storageRepository) {
        this.storageRepository = storageRepository;
    }

    @GetMapping("/getuploadfiles")
    public String listUploadedFiles(Model model) throws IOException {

        model.addAttribute("files", storageRepository.loadAll().map(
                path -> MvcUriComponentsBuilder.fromMethodName(UploadFileController.class,
                        "serveFile", path.getFileName().toString()).build().toUri().toString())
                .collect(Collectors.toList()));

        return "uploadForm";
    }

    @GetMapping("/files/{filename}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageRepository.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PostMapping("/handlefile")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        storageRepository.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }

    @ExceptionHandler(UploadFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(UploadFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}