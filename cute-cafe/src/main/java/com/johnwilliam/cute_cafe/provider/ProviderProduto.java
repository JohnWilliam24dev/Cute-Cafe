package com.johnwilliam.cute_cafe.provider;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import com.johnwilliam.cute_cafe.entities.Produto;
public class ProviderProduto {
    
    private String getFileExtension(Path path) {
        String filename = path.getFileName().toString();
        int lastDotIndex = filename.lastIndexOf('.');

        if (lastDotIndex == -1 || lastDotIndex == filename.length() - 1) {
            return "";
        }

        return filename.substring(lastDotIndex + 1);
    }

    public boolean save(Produto produto){
        Path origin_dir=Paths.get(produto.getImagem());
        Path destiny_dir= Paths.get("images",produto.getNome()+"."+getFileExtension(origin_dir));
        if (!Files.exists(destiny_dir.getParent())) {
            try {
                Files.createDirectories(destiny_dir.getParent());
            } catch (IOException e) {
                return false;
            }
        }
        if (Files.exists(origin_dir)) {
            try {
                Files.copy(origin_dir, destiny_dir, StandardCopyOption.REPLACE_EXISTING);
                produto.setImagem(destiny_dir.toString());

                return true;
            } catch (IOException e) {
                return false;
            }
        }
        return false;
    }
    public boolean delete(Produto produto){
        Path file = Paths.get(produto.getImagem());
        if (Files.exists(file)) {
            try {
                Files.delete(file);
                
                return true;
            } catch (IOException e) {
                
                e.printStackTrace();
                return false;
            }
        } 
        return false;
    }
    public boolean update(Produto produto){
        Path origin_dir=Paths.get(produto.getImagem());
        Path destiny_dir= Paths.get("images",produto.getNome()+"."+getFileExtension(origin_dir));
        if (Files.exists(origin_dir)) {
            try {
                Files.copy(origin_dir, destiny_dir, StandardCopyOption.REPLACE_EXISTING);
                produto.setImagem(destiny_dir.toString());

                return true;
            } catch (IOException e) {
                return false;
            }
        }
        return false;
    }
}
