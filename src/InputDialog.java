
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class InputDialog extends JTextArea {

    public static final int NEW_SAVE_OPTION = 0;
    public static final int NEW_DISCARD_OPTION = 1;

    public int showQuestionMessage() {
        return JOptionPane.showOptionDialog(
                this,
                "Vom Textanfang suchen?",
                "Nicht gefunden",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                null
        );
    }

    public void showInfoMessage() {
        JOptionPane.showMessageDialog(
                this,
                "<html>"
                + "<b>Copyright © 2026</b><br>"
                + "<h1>Tomas Pham</h1>"
                + "<p>RBBK Klasse - ITO8</p>"
                + "<p>Projektbeginn: 28.09.2026</p>"
                + "<h2>Zusatzfunktion: Gespeicherte Textstände</h2>"
                + "Die Schaltflächen 'Rückgängig' und 'Wiederholen' unter dem Editor-Fenster sowie im Menü-Option 'Datei' &gt; 'Rückgängig / Wiederholen' wechseln zwischen gespeicherten Textständen.<br>"
                + "Strg+Z: geht zurück; Strg+Y: stellt den nächsten Textstand wieder her.<br>"
                + "Ein erfolgreicher Speichervorgang legt bei geändertem Text einen neuen Wiederherstellungspunkt an.<br>"
                + "<b>Achtung:</b> Ungespeicherte Änderungen sind keine eigenen Schritte.<br>"
                + "Rückgängig setzt den Text zuerst auf den letzten Speicherstand zurück und verwirft diese Änderungen.<br>"
                + "Speichern Sie wichtige Zwischenstände regelmäßig.<br>"
                + "Beim Erstellen eines neuen Dokuments oder Laden einer Datei beginnt der Verlauf neu."
                + "</html>",
                "Info",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static int showConfirmExitDialog(Component parent) {
        return showConfirmation(parent, "Der Text wurde geändert. Möchten Sie den Editor wirklich beenden?", "Editor beenden");
    }

    public static int showConfirmNewDocumentDialog(Component parent) {
        return JOptionPane.showOptionDialog(
                parent,
                "Der Text wurde geändert. Möchten Sie ihn vor dem Erstellen eines neuen Dokuments speichern?",
                "Neues Dokument",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Speichern", "Verwerfen", "Abbrechen"},
                "Speichern"
        );
    }

    public static int showConfirmLoadNewDocumentDialog(Component parent) {
        return JOptionPane.showOptionDialog(
                parent,
                "Der Text wurde geändert. Möchten Sie ihn vor Laden eines neuen Dokuments speichern?",
                "Neues Dokument laden",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Speichern", "Verwerfen", "Abbrechen"},
                "Speichern"
        );
    }

    public static void showDocumentLoadSaved(Component parent) {
        showDocumentLoadFeedback(
                parent,
                "Änderungen wurden gespeichert. Wählen Sie jetzt eine Datei zum Laden aus.",
                "Speichern erfolgreich",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void showDocumentLoadSaveCancelled(Component parent) {
        showDocumentLoadFeedback(
                parent,
                "Speichern wurde abgebrochen. Das Laden wurde nicht gestartet; Ihre Änderungen bleiben erhalten.",
                "Laden abgebrochen",
                JOptionPane.WARNING_MESSAGE
        );
    }

    public static void showDocumentLoadSaveFailed(Component parent, String saveMessage) {
        showDocumentLoadFeedback(
                parent,
                "Die Änderungen wurden nicht gespeichert. Das Laden wurde abgebrochen, damit der aktuelle Text erhalten bleibt.\n\n"
                + saveMessage,
                "Speichern fehlgeschlagen",
                JOptionPane.ERROR_MESSAGE
        );
    }

    public static void showDocumentLoadDiscardNotice(Component parent) {
        showDocumentLoadFeedback(
                parent,
                "Die Änderungen wurden nicht gespeichert. Wenn Sie jetzt eine Datei laden, wird der aktuelle Text ersetzt.\n"
                + "Brechen Sie die Dateiauswahl ab, bleibt der aktuelle Text geöffnet.",
                "Änderungen nicht gespeichert",
                JOptionPane.WARNING_MESSAGE
        );
    }

    private static void showDocumentLoadFeedback(
            Component parent, String message, String title, int messageType) {
        JOptionPane.showMessageDialog(parent, message, title, messageType);
    }

    public static int showConfirmOverwriteFileDialog(Component parent) {
        return showConfirmation(parent, "Die Datei existiert bereits. Soll sie überschrieben werden?", "Datei überschreiben");
    }

    private static int showConfirmation(
            Component parent, String message, String title) {
        return JOptionPane.showConfirmDialog(
                parent, message, title, JOptionPane.YES_NO_OPTION
        );
    }
}
