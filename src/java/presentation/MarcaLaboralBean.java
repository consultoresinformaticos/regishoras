package presentation;

import business.boundary.MarcaLaboralManager;
import business.boundary.MarcaMotivoManager;
import business.boundary.SucursalManager;
import business.entity.MarcaLaboral;
import business.entity.MarcaMotivo;
import business.entity.Sucursal;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.apache.log4j.Logger;

/**
 *
 * @author enrique
 */
@ViewScoped
@Model
public class MarcaLaboralBean implements Serializable {

    @Inject
    private SucursalManager sucursalManager;
    @Inject
    private MarcaLaboralManager marcaLaboralManager;
    @Inject
    private MarcaMotivoManager marcaMotivoManager;
    private List<Sucursal> sucursalList;
    private LoginBean loginBean;
    private MarcaLaboral marcaLaboral;
    private List<MarcaMotivo> marcaMotivoList;
    protected Logger logger = Logger.getLogger(MarcaLaboralBean.class);
    private String motivo;
    private Sucursal sucursal;
    private MarcaMotivo marcaMotivo;

    @PostConstruct
    public void init() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        loginBean = (LoginBean) externalContext.getSessionMap().get("loginBean");
        marcaLaboral = new MarcaLaboral();
        if (null != loginBean) {
            marcaLaboral.setUsuario(loginBean.getUsuario());
        }
        sucursalList = sucursalManager.getAll();
        marcaMotivoList = marcaMotivoManager.getAll();
    }

    /**
     * Agrega una nueva marca laboral.
     *
     * @return
     */
    public String add() {
        try {
            if (loginBean == null || !loginBean.isLoggedIn() || null == loginBean.getUsuario()) {
                return "login";
            }
            marcaLaboral.setUsuario(loginBean.getUsuario());
            marcaLaboral.setFecMarcacion(new Date());
            marcaLaboralManager.add(marcaLaboral);
            this.init();
            String summary = Util.getMessage().getProperty("marcacion.marcalavoral.sussess");
            Util.addMessage(summary, FacesMessage.SEVERITY_INFO);
            logger.info(summary);
        } catch (Exception e) {
            String summary = Util.getMessage().getProperty("marcacion.marcalavoral.error");
            Util.addMessage(summary, FacesMessage.SEVERITY_ERROR);
            logger.error("CLASS: " + this.getClass().getName() + " METHOD: add ", e);
        }
        return "";
    }

    public List<Sucursal> getSucursalList() {
        return sucursalList;
    }

    public void setSucursalList(List<Sucursal> sucursalList) {
        this.sucursalList = sucursalList;
    }

    public MarcaLaboral getMarcaLaboral() {
        return marcaLaboral;
    }

    public void setMarcaLaboral(MarcaLaboral marcaLaboral) {
        this.marcaLaboral = marcaLaboral;
    }

    public List<MarcaMotivo> getMarcaMotivoList() {
        return marcaMotivoList;
    }

    public void setMarcaMotivoList(List<MarcaMotivo> marcaMotivoList) {
        this.marcaMotivoList = marcaMotivoList;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public MarcaMotivo getMarcaMotivo() {
        return marcaMotivo;
    }

    public void setMarcaMotivo(MarcaMotivo marcaMotivo) {
        this.marcaMotivo = marcaMotivo;
    }

}
