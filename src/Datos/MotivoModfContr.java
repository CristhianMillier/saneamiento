package Datos;

public class MotivoModfContr {
    private int idActVivienda;
    private Vivienda objV;
    private String fechaDoc;
    private String asunto;
    private String tipoDoc = "Solicitud";
    private String fechaRec;
    private String destinatario;
    private byte[] archivopdf;
    private Contribuyente objC;

    public MotivoModfContr() {
    }

    public MotivoModfContr(int idActVivienda, Vivienda objV, String fechaDoc, String asunto, String fechaRec, String destinatario, byte[] archivopdf, Contribuyente objC) {
        this.idActVivienda = idActVivienda;
        this.objV = objV;
        this.fechaDoc = fechaDoc;
        this.asunto = asunto;
        this.fechaRec = fechaRec;
        this.destinatario = destinatario;
        this.archivopdf = archivopdf;
        this.objC = objC;
    }

    public int getIdActVivienda() {
        return idActVivienda;
    }

    public void setIdActVivienda(int idActVivienda) {
        this.idActVivienda = idActVivienda;
    }

    public Vivienda getObjV() {
        return objV;
    }

    public void setObjV(Vivienda objV) {
        this.objV = objV;
    }

    public String getFechaDoc() {
        return fechaDoc;
    }

    public void setFechaDoc(String fechaDoc) {
        this.fechaDoc = fechaDoc;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getFechaRec() {
        return fechaRec;
    }

    public void setFechaRec(String fechaRec) {
        this.fechaRec = fechaRec;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public byte[] getArchivopdf() {
        return archivopdf;
    }

    public void setArchivopdf(byte[] archivopdf) {
        this.archivopdf = archivopdf;
    }

    public Contribuyente getObjC() {
        return objC;
    }

    public void setObjC(Contribuyente objC) {
        this.objC = objC;
    }
    
    
}
