/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkup.dtosnegocios.cu.admgrupo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import linkup.objetosnegocio.cu.admgrupo.Grupo;
import linkup.objetosnegocio.cu.admgrupo.UsuarioAG;

/**
 *
 * @author gael_
 */
public class GrupoMapper {
    public GrupoMapper() {
    }
    
      public static Grupo toEntidad(GrupoDTO dto, List<UsuarioAG> usuariosDisponibles) {
        if (dto == null) return null;

        List<UsuarioAG> miembros = new ArrayList<>();
        for (String nombre : dto.getNombreMiembros()) {
            for (UsuarioAG u : usuariosDisponibles) {
                if (u.getNombre().equalsIgnoreCase(nombre)) {
                    miembros.add(u);
                    break;
                }
            }
        }

        return new Grupo(
            dto.getNombre(),
            LocalDateTime.now(),
            miembros,
            dto.getMensajes() != null ? dto.getMensajes() : new ArrayList<>()
        );
    }
}
