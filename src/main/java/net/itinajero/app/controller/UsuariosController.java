package net.itinajero.app.controller;

import net.itinajero.app.model.Perfil;
import net.itinajero.app.model.Usuario;
import net.itinajero.app.service.IPerfilService;
import net.itinajero.app.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private IUsuarioService serviceUsuario;
    @Autowired
    private IPerfilService servicePerfil;

    @GetMapping("/demo-bcrypt")
    public String pruebaBCrypt(){
        String password = "hectorm123";
        String encrypted = encoder.encode(password);
        System.out.println(encrypted);

        return "usuarios/demo";
    }

    @GetMapping(value = "/create")
    public String crear(@ModelAttribute Usuario usuario){
        return "usuarios/formUsuario";
    }

    @GetMapping("/index")
    public String index(){
        return "usuarios/listUsuarios";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute Usuario usuario, Model model, @RequestParam String perfil){
        String simplePass = usuario.getPwd();
        String encrypted = encoder.encode(simplePass);
        usuario.setPwd(encrypted);
        usuario.setActivo(1);
        serviceUsuario.guardar(usuario);

        Perfil p = new Perfil();
        p.setCuenta(usuario.getCuenta());
        p.setPerfil(perfil);
        servicePerfil.guardar(p);

        return "redirect:/usuarios/index";
    }

}
