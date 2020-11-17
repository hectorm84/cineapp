package net.itinajero.app.service;

import net.itinajero.app.model.Perfil;
import net.itinajero.app.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilServiceJPA  implements IPerfilService {

    @Autowired
    private PerfilRepository perfilRepo;

    @Override
    public void guardar(Perfil perfil) {
        perfilRepo.save(perfil);
    }

    @Override
    public List<Perfil> buscarTodos() {
        return perfilRepo.findAll();
    }

    @Override
    public Perfil buscarPorId(int idPerfil) {
        Optional<Perfil> op = perfilRepo.findById(idPerfil);
        if(op.isPresent()){
            return op.get();
        }
        return null;
    }
}
