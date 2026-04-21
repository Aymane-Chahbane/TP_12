package exercice_2;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * Générateur de page HTML basique.
 */
public class HtmlGenerator {

    /**
     * Crée un fichier HTML avec un titre et un paragraphe.
     *
     * @param path      chemin du fichier HTML
     * @param pageTitle titre de la page
     * @param bodyText  texte du paragraphe
     */
    public static void writeHtml(String path, String pageTitle, String bodyText) {
        try (PrintWriter pw = new PrintWriter(path, "UTF-8")) {
            pw.println("<!DOCTYPE html>");
            pw.println("<html lang=\"fr\">");
            pw.println("<head>");
            pw.printf("  <meta charset=\"UTF-8\">%n");
            pw.printf("  <title>%s</title>%n", pageTitle);
            pw.println("</head>");
            pw.println("<body>");
            pw.printf("  <h1>%s</h1>%n", pageTitle);
            pw.printf("  <p>%s</p>%n", bodyText);
            pw.println("</body>");
            pw.println("</html>");
        } catch (IOException e) {
            System.err.println("Erreur lors de la génération HTML : " + e.getMessage());
        }
    }
}
