
package codigo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Maniacorp
 */
public class Principal {
  
    
    
    public static void main(String[] args) throws Exception {
        String Direccion = System.getProperty("user.dir");
        String ruta1 = Direccion + "\\src\\codigo\\Lexer.flex";
        String ruta2 = Direccion + "\\src\\codigo\\LexerCup.flex";
        String[] rutaS = {"-parser","Sintax", Direccion +"\\src\\codigo\\Sintax.cup"};
        generar(ruta1, ruta2, rutaS , Direccion);
    }
    public static void generar(String ruta1, String ruta2, String[] rutaS , String direccion) throws IOException, Exception{
        File archivo;
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(rutaS);
        
        Path rutaSym = Paths.get(direccion + "\\src\\codigo\\sym.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get(direccion + "\\sym.java"), 
                Paths.get(direccion + "\\src\\codigo\\sym.java")
        );
        Path rutaSin = Paths.get(direccion + "\\src\\codigo\\Sintax.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get(direccion + "\\Sintax.java"), 
                Paths.get(direccion + "\\src\\codigo\\Sintax.java")
        );
    }
}
