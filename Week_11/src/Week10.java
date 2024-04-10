import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Week10 {
    /**
     * getAllFunction method.
     */
    public List<String> getAllFunctions(String fileContent) {
        List<String> methodSignatures = new ArrayList<>();
        String[] lines = fileContent.split("\\n");
        StringBuilder imports = new StringBuilder();

        // Collect imports
        for (String line : lines) {
            if (line.startsWith("import")) {
                imports.append(line).append(" ");
            }
        }

        // Regex to find static methods
        String methodPattern = "\\s*static\\s+([\\w\\s<>,]+)\\s+(\\w+)\\s*\\(([^)]*)\\)(\\s+throws\\s+[\\w\\s,]+)?";
        Pattern pattern = Pattern.compile(methodPattern);
        Matcher matcher = pattern.matcher(fileContent);

        while (matcher.find()) {
            String methodName = matcher.group(2);
            String params = matcher.group(3);
            String signature = buildSignature(methodName, params, imports.toString());
            methodSignatures.add(signature);
        }

        return methodSignatures;
    }

    private String buildSignature(String methodName, String params, String imports) {
        if (params.isEmpty()) {
            return methodName + "()";
        }

        String[] paramList = params.split(",");
        StringBuilder paramTypes = new StringBuilder();

        for (String param : paramList) {
            String[] parts = param.trim().split("\\s+");
            String type = getFullyQualifiedTypeName(parts[0], imports);
            if (parts.length > 1) { // Check for array or generics
                type += parts[1].contains("[]") ? "[]" : "";
            }
            paramTypes.append(type).append(",");
        }

        paramTypes.setLength(paramTypes.length() - 1); // Remove trailing comma
        return methodName + "(" + paramTypes + ")";
    }

    private String getFullyQualifiedTypeName(String type, String imports) {
        // Check if the type is a primitive type or 'void'
        if (Arrays.asList("int", "long", "double", "float",
                "boolean", "char", "byte", "short", "void").contains(type)) {
            return type;
        }

        if (type.contains(".")) {
            return type; // Already fully qualified
        }

        String[] importStatements = imports.split(" ");
        for (String importStmt : importStatements) {
            if (importStmt.endsWith("." + type + ";")) {
                return importStmt.replace("import ", "").replace(";", "");
            }
        }

        // If it's not a primitive type or explicitly imported, assume java.lang
        return "java.lang." + type;
    }
}