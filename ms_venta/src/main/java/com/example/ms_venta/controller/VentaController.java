package com.example.ms_venta.controller;

import com.example.ms_venta.entity.Venta;
import com.example.ms_venta.service.VentaService;
import com.example.ms_venta.utils.PdfUtils;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/venta")
public class VentaController {
    @Autowired
    private VentaService ventaService;
    @GetMapping()
    public ResponseEntity<List<Venta>> list(){
        return ResponseEntity.ok().body(ventaService.listar());
    }
    @PostMapping()
    public ResponseEntity<Venta> save(@RequestBody Venta venta){
        return ResponseEntity.ok(ventaService.guardar(venta));
    }
    @PutMapping()
    public ResponseEntity<Venta> update(@RequestBody Venta venta){
        return ResponseEntity.ok(ventaService.actualizar(venta));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Venta> listById(@PathVariable(required = true) Integer id){
        return ResponseEntity.ok().body(ventaService.listarPorId(id).get());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Venta>>eliminar(@PathVariable(required = true) Integer id){
        ventaService.eliminarPorId(id);
        return ResponseEntity.ok(ventaService.listar());
    }
    @GetMapping("/pdf")
    public ResponseEntity<byte[]> exportPdf() throws IOException, DocumentException {
        //List<Map<String, Object>> queryResults = myService.executeQuery(request);
        ByteArrayOutputStream pdfStream = PdfUtils.generatePdfStream(ventaService.listar());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=query_results.pdf");
        headers.setContentLength(pdfStream.size());
        return new ResponseEntity<>(pdfStream.toByteArray(), headers, HttpStatus.OK);
    }
    @PostMapping("/upload")
    @ResponseBody
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "Error: Por favor selecciona un archivo para subir.";
        }

        try {
            // Obtener el nombre del archivo original
            String fileName = file.getOriginalFilename();
            if (fileName == null || fileName.contains("..")) {
                return "Error: Nombre de archivo inválido.";
            }

            // Validar el tipo de archivo
            //String contentType = file.getContentType();
            //List<String> allowedContentTypes = Arrays.asList("image/jpeg", "image/png", "application/pdf");
            //if (!allowedContentTypes.contains(contentType)) {
                //return "Error: Tipo de archivo no permitido.";
            //}

            // Guardar el archivo en el directorio base del proyecto
            String projectBaseDir = System.getProperty("user.dir");
            String uploadDir = projectBaseDir + File.separator + "uploads";
            File uploadDirFile = new File(uploadDir);
            if (!uploadDirFile.exists()) {
                uploadDirFile.mkdirs();
            }

            // Añadir un identificador único al nombre del archivo para evitar duplicados
            String uniqueFileName = UUID.randomUUID().toString() + "_" + fileName;
            String filePath = uploadDir + File.separator + uniqueFileName;
            File dest = new File(filePath);
            file.transferTo(dest);

            return "Archivo subido exitosamente: " + uniqueFileName;
        } catch (IOException e) {
            return "Error al subir el archivo: " + e.getMessage();
        }
    }
}
