package ${basePackage}.controller;

import ${basePackage}.core.ProjectConstant;
import ${basePackage}.core.Result;
import ${basePackage}.core.ResultGenerator;
import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.service.${modelNameUpperCamel}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;

/**
 * Created by ${author} on ${date}.
 */
@Api
@RestController
@RequestMapping(value = "/${modelNameLowerCamel}")
public class ${modelNameUpperCamel}Controller {

    @Autowired
    ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @PostMapping
    public Result add(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.save(${modelNameLowerCamel});
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.update(${modelNameLowerCamel}, ${modelNameLowerCamel}.getId());
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = ProjectConstant.PRODUCES_JSON)
    public Result delete(@PathVariable ${idType} id) {
        ${modelNameLowerCamel}Service.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = ProjectConstant.PRODUCES_JSON)
    public Result detail(@PathVariable ${idType} id) {
        ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.findById(id);
        return ResultGenerator.genSuccessResult(${modelNameLowerCamel});
    }

    @RequestMapping(method = RequestMethod.GET, produces = ProjectConstant.PRODUCES_JSON)
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) {
        Pageable pageable = new PageRequest(page, size);
        return ResultGenerator.genSuccessResult(${modelNameLowerCamel}Service.findAll(pageable));
    }

}