package net.itinajero.app.service;

import net.itinajero.app.model.Usuario;
import net.itinajero.app.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceJPA implements IUsuarioService{
    @Autowired
    UsuariosRepository usuarioRepo;

    @Override
    public void guardar(Usuario usuario) {
        usuarioRepo.save(usuario);
    }

    @Override
    public List<Usuario> buscarTodos() {
        return usuarioRepo.findAll();
    }

    @Override
    public Usuario buscarPorId(int idUsuario) {
        Optional<Usuario> op = usuarioRepo.findById(idUsuario);
        if(op.isPresent()){
            return op.get();
        }
        return null;
    }

    @Override
    public void eliminarPorid(int idUsuario) {
        usuarioRepo.deleteById(idUsuario);
    }
}
