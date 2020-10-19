package be.howest.ti.shop.data.json.util;

import be.howest.ti.shop.data.Repositories;
import be.howest.ti.shop.data.Repository;
import be.howest.ti.shop.domain.Category;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;

public class StringToCategoryConverter implements Converter<String, Category> {
    @Override
    public Category convert(String name) {
        return Repositories.getCurrentRepository().getCategoryByName(name);
    }

    @Override
    public JavaType getInputType(TypeFactory typeFactory) {
        return typeFactory.constructSimpleType(String.class, new JavaType[]{});
    }

    @Override
    public JavaType getOutputType(TypeFactory typeFactory) {
        return typeFactory.constructSimpleType(Category.class, new JavaType[]{});
    }
}
