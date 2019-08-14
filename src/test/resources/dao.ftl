package ${basePackage}.dao;

import ${basePackage}.model.${modelNameUpperCamel};
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ${author} on ${date}.
 */
public interface ${modelNameUpperCamel}Dao extends JpaRepository<${modelNameUpperCamel}, ${idType}> {
}
