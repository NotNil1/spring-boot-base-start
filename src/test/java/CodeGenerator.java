import com.google.common.base.CaseFormat;
import com.notnil.base.core.ProjectConstant;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * @author NotNil
 */
public class CodeGenerator {

    private static Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);

    private static final String PROJECT_PATH = System.getProperty("user.dir");
    private static final String TEMPLATE_FILE_PATH = PROJECT_PATH + "/src/test/resources";
    private static final String JAVA_PATH = "/src/main/java";

    private static final String PACKAGE_PATH_SERVICE = packageConvertPath(ProjectConstant.SERVICE_PACKAGE);
    private static final String PACKAGE_PATH_SERVICE_IMPL = packageConvertPath(ProjectConstant.SERVICE_IMPL_PACKAGE);
    private static final String PACKAGE_PATH_CONTROLLER = packageConvertPath(ProjectConstant.CONTROLLER_PACKAGE);
    private static final String PACKAGE_PATH_DAO = packageConvertPath(ProjectConstant.DAO_PACKAGE);

    private static Map<String, Object> data = new HashMap<>();

    static {
        try {
            cfg.setDirectoryForTemplateLoading(new File(TEMPLATE_FILE_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);

        data.put("date", LocalDate.now().toString());
        data.put("author", "CodeGenerator");
        data.put("basePackage", ProjectConstant.BASE_PACKAGE);
    }


    public static void main(String[] args) {
        data.put("idType", "Long");
        genCode("User");
    }

    private static void genCode(String... modelNames) {
        for (String modelName : modelNames) {
            data.put("modelNameUpperCamel", modelName);
            data.put("modelNameLowerCamel", CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, modelName));
            genCodeByCustomModelName(modelName);
        }
    }

    private static void genCodeByCustomModelName(String modelName) {
        genDao(modelName);
        genService(modelName);
        genController(modelName);
    }

    private static void genDao(String modelName) {
        try {
            File file = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_DAO + modelName + "Dao.java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            cfg.getTemplate("dao.ftl").process(data, new FileWriter(file));
            System.out.println(modelName + "Dao.java" + " 生成成功");
        } catch (Exception e) {
            throw new RuntimeException("生成Dao失败", e);
        }
    }

    private static void genService(String modelName) {
        try {
            File file = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_SERVICE + modelName + "Service.java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            cfg.getTemplate("service.ftl").process(data,
                new FileWriter(file));
            System.out.println(modelName + "Service.java 生成成功");

            File file1 = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_SERVICE_IMPL + modelName + "ServiceImpl.java");
            if (!file1.getParentFile().exists()) {
                file1.getParentFile().mkdirs();
            }
            cfg.getTemplate("serviceImpl.ftl").process(data,
                new FileWriter(file1));
            System.out.println(modelName + "ServiceImpl.java 生成成功");

        } catch (Exception e) {
            throw new RuntimeException("生成Service失败", e);
        }
    }

    private static void genController(String modelName) {
        try {
            File file = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_CONTROLLER + modelName + "Controller.java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            cfg.getTemplate("controller.ftl").process(data, new FileWriter(file));
            System.out.println(modelName + "Controller.java" + " 生成成功");
        } catch (Exception e) {
            throw new RuntimeException("生成Controller失败", e);
        }
    }

    private static String packageConvertPath(String packageName) {
        return String.format("/%s/", packageName.contains(".") ? packageName.replaceAll("\\.", "/") : packageName);
    }

}


