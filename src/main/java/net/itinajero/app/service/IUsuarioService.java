package net.itinajero.app.service;

import net.itinajero.app.model.Usuario;

import java.util.List;

public interface IUsuarioService {
    void guardar(Usuario usuario);
    List<Usuario> buscarTodos();
    Usuario buscarPorId(int idUsuario);
    void eliminarPorid(int idUsuario);

}
