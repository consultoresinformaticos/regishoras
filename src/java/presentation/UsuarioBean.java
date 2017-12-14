package presentation;

import business.boundary.CiudadManager;
import business.boundary.DepartamentoManager;
import business.boundary.PersonalManager;
import business.boundary.RolManager;
import business.boundary.UsuarioManager;
import business.entity.Ciudad;
import business.entity.Departamento;
import business.entity.Presona;
import business.entity.Rol;
import business.entity.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import javax.inject.Inject;

/**
 *
 * @author bala
 */
@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {

    @Inject
    private UsuarioManager usuarioManager;
    @Inject
    private RolManager rolManager;
    @Inject
    private CiudadManager ciudadManager;
    @Inject
    private DepartamentoManager departamentoManager;
    @Inject
    private PersonalManager personalManager;
    private List<Ciudad> ciudadList;
    private List<Rol> rolList;
    private Usuario usuarioSelected;
    private List<Usuario> usuarioList;
    private List<Departamento> departamentoList;
    private Departamento departamentoSelected;
    private Presona persona;
    private String password;
    private String repeatPassword;
    private Integer active;

    @PostConstruct
    public void init() {
        usuarioList = usuarioManager.getAll();
        Clean();
    }

    public void add() {
        //validPassowrd();
        Date fechaAlta = new Date();
        usuarioSelected.setFecAlta(fechaAlta);
        usuarioSelected.getPresona().setFechAlta(fechaAlta);
        usuarioSelected.getPresona().setCiudadId(ciudadManager.getById(1));
        usuarioSelected.getPresona().setActivo(active);
        usuarioSelected.setActivo(active);
        usuarioManager.add(usuarioSelected);
        usuarioList = usuarioManager.getAll();
    }

    public void changeState() {
        usuarioSelected.setActivo(active);
        usuarioManager.update(usuarioSelected);
    }

    public void delete() {
        usuarioManager.delete(usuarioSelected);
    }

    public void modify() {
        usuarioManager.update(usuarioSelected);
    }

    public String genInfo() {
        return null;
    }

    public void Clean() {
        usuarioSelected = new Usuario();
        persona = new Presona();
        usuarioSelected.setPresona(persona);
        rolList = rolManager.getAll();
        departamentoList = departamentoManager.getAll();
        ciudadList = new ArrayList<Ciudad>();
    }

    public void validatePassword(ComponentSystemEvent event) {

        FacesContext fc = FacesContext.getCurrentInstance();

        UIComponent components = event.getComponent();

        // get password
        UIInput uiInputPassword = (UIInput) components.findComponent("password");
        String password = uiInputPassword.getLocalValue() == null ? ""
                : uiInputPassword.getLocalValue().toString();
        String passwordId = uiInputPassword.getClientId();

        // get confirm password
        UIInput uiInputConfirmPassword = (UIInput) components.findComponent("validateSamePassword");
        String confirmPassword = uiInputConfirmPassword.getLocalValue() == null ? ""
                : uiInputConfirmPassword.getLocalValue().toString();

        // Let required="true" do its job.
        if (password.isEmpty() || confirmPassword.isEmpty()) {
            return;
        }

        if (!password.equals(confirmPassword)) {

            FacesMessage msg = new FacesMessage("Password must match confirm password");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            fc.addMessage(passwordId, msg);
            fc.renderResponse();

        }

    }

    public void getCities() {
        try {
            ciudadList = ciudadManager.getByDepartamento(departamentoSelected.getDepartamento());
        } catch (Exception e) {
            ciudadList = new ArrayList<Ciudad>();
        }
    }

    public void validateSamePassword(FacesContext context, UIComponent toValidate, Object value) {
        String confirmPassword = (String) value;
        if (!confirmPassword.equals(usuarioSelected.getPassword())) {
            String summary = "Usuario o contraseña incorrecta";
            Util.addMessage(summary, FacesMessage.SEVERITY_ERROR);
        }
    }

    public List<Ciudad> getCiudadList() {
        return ciudadList;
    }

    public void setCiudadList(List<Ciudad> ciudadList) {
        this.ciudadList = ciudadList;
    }

    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    public Usuario getUsuarioSelected() {
        return usuarioSelected;
    }

    public void setUsuarioSelected(Usuario usuarioSelected) {
        this.usuarioSelected = usuarioSelected;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public List<Departamento> getDepartamentoList() {
        return departamentoList;
    }

    public void setDepartamentoList(List<Departamento> departamentoList) {
        this.departamentoList = departamentoList;
    }

    public Departamento getDepartamentoSelected() {
        return departamentoSelected;
    }

    public void setDepartamentoSelected(Departamento departamentoSelected) {
        this.departamentoSelected = departamentoSelected;
    }

    public Presona getPersona() {
        return persona;
    }

    public void setPersona(Presona persona) {
        this.persona = persona;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

}
