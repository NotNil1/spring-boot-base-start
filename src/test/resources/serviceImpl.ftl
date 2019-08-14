package ${basePackage}.service.impl;

import ${basePackage}.service.AbstractService;
import ${basePackage}.dao.${modelNameUpperCamel}Dao;
import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.service.${modelNameUpperCamel}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ${author} on ${date}.
 */
@Service
public class ${modelNameUpperCamel}ServiceImpl extends AbstractService<${modelNameUpperCamel}, ${idType}> implements ${modelNameUpperCamel}Service {
    @Autowired
    ${modelNameUpperCamel}Dao ${modelNameLowerCamel}Dao;
}