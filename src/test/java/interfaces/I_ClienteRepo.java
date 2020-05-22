package interfaces;
import entidades.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public interface I_ClienteRepo {
    void inserta(Cliente cliente);
     
//    List<Cliente>getAll();
//    default Cliente getById(int id){
//        return getAll()
//                .stream()
//                .filter(a->a.getId()==id)
//                .findFirst()
//                .orElse(new Cliente());
//    }
//    default List<Cliente>getLikeNombreApellido(String nombre,String apellido){
//        if(nombre==null || apellido==null) return new ArrayList<Cliente>();
//        return getAll()
//                .stream()
//                .filter(a->a.getApellido().toLowerCase().contains(apellido.toLowerCase())
//                        && a.getNombre().toLowerCase().contains(nombre.toLowerCase()))
//                .collect(Collectors.toList());
//    }
    
}