package mapper;
import dto.VolumeInfo;
import modelo.Livro;
public class LivroMapper {
    public static Livro conversao (VolumeInfo dto){

        if(dto == null){
            return null;
        }

        String authors = dto.authors() !=null
                ?String.join(" ,", dto.authors())
                : "Autor desconhecido";


        return new Livro(
                dto.title(),
                authors,
                dto.publishedDate()
        );


    }
}
