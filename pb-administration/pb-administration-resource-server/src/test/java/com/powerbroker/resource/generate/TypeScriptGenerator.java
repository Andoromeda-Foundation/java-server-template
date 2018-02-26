package com.powerbroker.resource.generate;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.text.StrSubstitutor;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TypeScriptGenerator {

    private static final String outputFolderPath = "D:/project/zx/pb-auth-web/src/app/template-typescript";

    private static final String serviceSourceFilePath = "template-typescript/target.service.ts.txt";

    private static final String listSourceFilePath = "template-typescript/target-list.component.ts.txt";

    private static final String editSourceFilePath = "template-typescript/target-detail.component.ts.txt";

    private static final String newSourceFilePath = "template-typescript/target.ts.txt";

    private String modelName;

    private String variableName;

    private String filePathName;

    private String serviceTemplatePath = Thread.currentThread().getContextClassLoader().getResource(serviceSourceFilePath).getFile();

    private String listTemplatePath = Thread.currentThread().getContextClassLoader().getResource(listSourceFilePath).getFile();

    private String editTemplatePath = Thread.currentThread().getContextClassLoader().getResource(editSourceFilePath).getFile();

    private String newTemplatePath = Thread.currentThread().getContextClassLoader().getResource(newSourceFilePath).getFile();

    private StrSubstitutor strSubstitutor;

    public TypeScriptGenerator(String modelName) {
        this.modelName = modelName;
        this.variableName = buildVariableName(modelName);
        this.filePathName = buildFilePathName(modelName);
    }

    public void execute() {
        try {

            Map<String, String> map = new HashMap<>();

            map.put("target-file-path", filePathName);
            map.put("target-model", modelName);
            map.put("target-variable", variableName);

            strSubstitutor = new StrSubstitutor(map, "{", "}");

            generateServiceFile();

            generateListFile();

            generateEditFile();

            generateTypeFile();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void generateServiceFile() throws IOException {

        String fileName = strSubstitutor.replace("{target-file-path}.service.ts");

        generateFile(fileName, serviceTemplatePath);

    }


    private void generateListFile() throws IOException {

        String fileName = strSubstitutor.replace("{target-file-path}-list.component.ts");

        generateFile(fileName, listTemplatePath);

    }

    private void generateEditFile() throws IOException {

        String fileName = strSubstitutor.replace("{target-file-path}-detail.component.ts");

        generateFile(fileName, editTemplatePath);

    }

    private void generateTypeFile() throws IOException {

        String fileName = strSubstitutor.replace("{target-file-path}.ts");

        generateFile(fileName, newTemplatePath);

    }


    private void generateFile(String fileName, String tempaltePath) throws IOException {

        String fileString = FileUtils.readFileToString(FileUtils.getFile(tempaltePath));

//        fileString = strSubstitutor.replace(fileString);

        fileString = fileString.replace("{target-variable}", variableName).replace("{target-model}", modelName).replace("{target-file-path}", filePathName);

        System.out.println(fileString);

        File output = new File(outputFolderPath + "/" + filePathName + "/" + fileName);

        System.out.println(output.getAbsolutePath());

        FileUtils.writeStringToFile(output, fileString);
    }


    private String buildFilePathName(String modelName) {
        return addHyphens(modelName);
    }


    private String buildVariableName(String modelName) {
        return modelName.substring(0, 1).toLowerCase() + modelName.substring(1);
    }


    private String addHyphens(String name) {
        StringBuilder buf = new StringBuilder(name);
        for (int i = 1; i < buf.length() - 1; i++) {
            if (
                    Character.isLowerCase(buf.charAt(i - 1)) &&
                            Character.isUpperCase(buf.charAt(i)) &&
                            Character.isLowerCase(buf.charAt(i + 1))
                    ) {
                buf.insert(i++, '-');
            }
        }
        return buf.toString().toLowerCase();
    }

    public static void main(String[] args) throws IOException {

        TypeScriptGenerator generator = new TypeScriptGenerator("OperationRecord");

        generator.execute();
    }

}
