package presentation;

import business.boundary.UsuarioManager;
import business.entity.Usuario;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

/**
 *
 * @author enrique
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private String username;
    private String password;
    private boolean loggedIn;
    private Usuario usuario;

    @Inject
    UsuarioManager usuariosMgr;

    public void init() {
        username = "";
        password = "";
        loggedIn = false;
        usuario = new Usuario();
    }

    public String logout() throws IOException {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        session.invalidate();
        loggedIn = false;
        FacesContext.getCurrentInstance().getExternalContext().redirect("../login.xhtml");
        return "login";
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String login() {
        usuario = usuariosMgr.authenticate(username, password);
        if (usuario != null) {
            loggedIn = true;
        }

        if (loggedIn) {
            return usuario.getRol().getRol();
        } else {
            loggedIn = false;
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error de acceso", "El usuario y la contraseña no coinciden");
            FacesContext.getCurrentInstance().addMessage(null, message);
            username = null;
            password = null;
            return "login";
        }
    }

    public void redirect() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("secure/inicio.xhtml");
    }

    public boolean getPermisoPantalla(String roles) {

        return true;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
