package com.adocao_api.service;

import com.adocao_api.model.Image;
import com.adocao_api.repository.ImageRepository;
import com.adocao_api.utils.ImageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository repository;

    public String uploadImage(MultipartFile file) throws IOException {
        var imageToSave = Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.comprimirImage(file.getBytes()));

        return "Arquivo salvo com sucesso : " + file.getOriginalFilename();
    }

    public byte[]downloadImage(String fileName) {
        Optional<Image> dbImage = repository.findByName(fileName);

        return dbImage.map(image -> {
            try {
                return ImageUtils.descompactarImage(image.getImageData());
            } catch (Exception exception) {
                throw new RuntimeException("Error downloading an image", exception);
            }
        }).orElse(null);
    }


}
