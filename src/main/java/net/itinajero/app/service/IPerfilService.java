package net.itinajero.app.service;

import net.itinajero.app.model.Perfil;

import java.util.List;

public interface IPerfilService {
    void guardar(Perfil perfil);
    List<Perfil> buscarTodos();
    Perfil buscarPorId(int idPerfil);

}
