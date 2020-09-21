package services;

import api.model.Category;
import api.model.Genre;
import com.crowdar.api.rest.MethodsService;
import com.crowdar.api.rest.Response;

public class GenreService extends MethodsService {

    public static Response get(String jsonName) {
        return get(jsonName, Genre.class);
    }
}
