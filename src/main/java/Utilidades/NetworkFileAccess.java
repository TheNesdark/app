package Utilidades;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import jcifs.CIFSContext;
import jcifs.config.PropertyConfiguration;
import jcifs.context.BaseContext;
import jcifs.smb.NtlmPasswordAuthenticator;
import jcifs.smb.SmbFile;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/NetworkFileAccess.class */
public class NetworkFileAccess {
    public static List<String> listFilesInSharedFolderLinux(String path, String username, String password) {
        List<String> fileNames = new ArrayList<>();
        try {
            NtlmPasswordAuthenticator auth = new NtlmPasswordAuthenticator(username, password);
            Properties prop = new Properties();
            prop.setProperty("jcifs.smb.client.disableSMB2", "false");
            CIFSContext context = new BaseContext(new PropertyConfiguration(prop)).withCredentials(auth);
            SmbFile smbFile = new SmbFile(path, context);
            System.out.println("path " + smbFile.getPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileNames;
    }

    public static String getPdfPath(String path, String username, String password, String pdfFileName) {
        try {
            NtlmPasswordAuthenticator auth = new NtlmPasswordAuthenticator(username, password);
            Properties prop = new Properties();
            prop.setProperty("jcifs.smb.client.disableSMB2", "false");
            CIFSContext context = new BaseContext(new PropertyConfiguration(prop)).withCredentials(auth);
            SmbFile pdfFile = new SmbFile(path + pdfFileName, context);
            return pdfFile.getURL().toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Not initialized variable reg: 16, insn: 0x013c: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r16 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('in' java.io.InputStream)]) A[TRY_LEAVE], block:B:42:0x013c */
    /* JADX WARN: Not initialized variable reg: 17, insn: 0x0141: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r17 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:44:0x0141 */
    public static void downloadAndOpenPdf(String path, String username, String password, String pdfFileName) {
        try {
            try {
                NtlmPasswordAuthenticator auth = new NtlmPasswordAuthenticator(username, password);
                Properties prop = new Properties();
                prop.setProperty("jcifs.smb.client.disableSMB2", "false");
                CIFSContext context = new BaseContext(new PropertyConfiguration(prop)).withCredentials(auth);
                System.out.println("as : " + pdfFileName);
                SmbFile smbPdfFile = new SmbFile(path + pdfFileName, context);
                File localTempFile = File.createTempFile("temp_pdf_", ".pdf");
                InputStream in = smbPdfFile.getInputStream();
                Throwable th = null;
                FileOutputStream out = new FileOutputStream(localTempFile);
                Throwable th2 = null;
                try {
                    try {
                        byte[] buffer = new byte[1024];
                        while (true) {
                            int bytesRead = in.read(buffer);
                            if (bytesRead == -1) {
                                break;
                            } else {
                                out.write(buffer, 0, bytesRead);
                            }
                        }
                        if (out != null) {
                            if (0 != 0) {
                                try {
                                    out.close();
                                } catch (Throwable th3) {
                                    th2.addSuppressed(th3);
                                }
                            } else {
                                out.close();
                            }
                        }
                        if (in != null) {
                            if (0 != 0) {
                                try {
                                    in.close();
                                } catch (Throwable th4) {
                                    th.addSuppressed(th4);
                                }
                            } else {
                                in.close();
                            }
                        }
                        if (Desktop.isDesktopSupported()) {
                            Desktop.getDesktop().open(localTempFile);
                        } else {
                            System.out.println("La apertura de archivos no es compatible en este sistema.");
                        }
                    } catch (Throwable th5) {
                        if (out != null) {
                            if (th2 != null) {
                                try {
                                    out.close();
                                } catch (Throwable th6) {
                                    th2.addSuppressed(th6);
                                }
                            } else {
                                out.close();
                            }
                        }
                        throw th5;
                    }
                } catch (Throwable th7) {
                    th2 = th7;
                    throw th7;
                }
            } finally {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
