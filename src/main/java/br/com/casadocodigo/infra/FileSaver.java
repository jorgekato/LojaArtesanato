/*
 * TODO Produto $(product_name} - ${product_description}<br>
 *
 * Data de Criação: 7 de abr de 2018<br>
 * <br>
 * Todos os direitos reservados.
 */
package br.com.casadocodigo.infra;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * DOCUMENTAÇÃO DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * Classe de configuração para uso de arquivos.
 * <br>
 * HISTÓRICO DE DESENVOLVIMENTO: <br>
 * 7 de abr de 2018 - @author jorge - Primeira versão da classe. <br>
 * <br>
 * <br>
 * LISTA DE CLASSES INTERNAS: <br>
 */
@Component
public class FileSaver {

    @Autowired
    private HttpServletRequest request;
    
    /**
     * 
     * Método que realiza a transferencia do arquivo e retorna o caminho relativo onde o arquiivo será salvo.
     * 
     * @param baseFolder - local onde o arquivo será salvo.
     * @param file - arquivo a salvar.
     * @return
     */
    public String write ( String baseFolder , MultipartFile file ) {
        try {
            String realPath = request.getServletContext().getRealPath( java.io.File.separator + baseFolder );
            String path = realPath + java.io.File.separator + file.getOriginalFilename();
            file.transferTo( new File( path ) );
            
            return baseFolder + java.io.File.separator + file.getOriginalFilename();
        }
        catch ( IllegalStateException | IOException e ) {
            throw new RuntimeException( e );
        }
    }
}
