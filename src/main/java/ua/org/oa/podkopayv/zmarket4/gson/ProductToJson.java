package ua.org.oa.podkopayv.zmarket4.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ua.org.oa.podkopayv.zmarket4.model.Product;

public class ProductToJson {

    public static String convert(Product product) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.registerTypeAdapter(Product.class, new ProductAdapter()).create();
        return gson.toJson(product);
    }

}
