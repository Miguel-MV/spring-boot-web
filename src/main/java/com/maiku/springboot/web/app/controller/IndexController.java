package com.maiku.springboot.web.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.maiku.springboot.web.app.models.Usuario;


@Controller
@RequestMapping("/app")
public class IndexController {
    
    @GetMapping({"/index", "/", "/home"})
    public String index(Model model){
        model.addAttribute("titulo", "Hola spring framework retornando string!");
        return "index";
    }

    @RequestMapping(path = "/perfil", method = RequestMethod.GET)
    public String perfil(Model model){
        Usuario usuario = new Usuario();
        usuario.setNombre("Maiku");
        usuario.setApellido("Laphoset");
        usuario.setEmail("maiku@gmail.com");

        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Perfil del usuario : " + usuario.getNombre());

        return "perfil";
    }

    @RequestMapping("/listar")
    public String listar(Model model){

        model.addAttribute("titulo", "Listado de usuarios");

        return "listar";
    }

    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Maiku", "Moreno", "laphoset@gmail.com"));
        usuarios.add(new Usuario("Himeko", "Uchiha", "teolotitla@gmail.com"));
        usuarios.add(new Usuario("Gran", "Zaharia", "ninja@gmail.com"));

        return usuarios;
    }

}
