package com.powerbroker.resource.entity;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ReflectBean {
    private Connection connection;
    /* mysql url的连接字符串 */
    private static String url = "jdbc:mysql://localhost:3306/power_broker?serverTimezone=UTC&amp;characterEncoding=utf-8";
    // 账号
    private static String user = "power_broker";
    // 密码
    private static String password = "power_broker";
    // mysql jdbc的java包驱动字符串
    private String driverClassName = "com.mysql.cj.jdbc.Driver";
    // 数据库中的表名
    String table = "operation_records";
    // 数据库的列名称
    private List<String> colnames; // 列名数组
    // 列名类型数组
    private List<String> colTypes;

    private List<String> ignores = Arrays.asList("id", "create_by", "create_at", "update_by", "update_at", "active",
            "deleted", "delete_by", "delete_at");

    private static String LF = "\r\n";

    private static String PADDING = " ";

    public ReflectBean() {
        try {// 驱动注册
            Class.forName(driverClassName);
            if (connection == null || connection.isClosed())
                // 获得链接
                connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("Oh,not");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Oh,not");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void doAction() {
        String sql = "select * from " + table;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            // 获取数据库的元数据
            ResultSetMetaData metadata = statement.getMetaData();
            // 数据库的字段个数
            int len = metadata.getColumnCount();
            // 字段名称
            colnames = new ArrayList<>();
            // 字段类型 --->已经转化为java中的类名称了
            colTypes = new ArrayList<>();
            for (int i = 1; i <= len; i++) {
                // System.out.println(metadata.getColumnName(i)+":"+metadata.getColumnTypeName(i)+":"+sqlType2JavaType(metadata.getColumnTypeName(i).toLowerCase())+":"+metadata.getColumnDisplaySize(i));
                // metadata.getColumnDisplaySize(i);
                String columnName = metadata.getColumnName(i);

                if (ignores.contains(columnName)) {
                    continue;
                }
                colnames.add(columnName); // 获取字段名称
                colTypes.add(sqlType2JavaType(metadata.getColumnTypeName(i))); // 获取字段类型
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
     * mysql的字段类型转化为java的类型
     */
    private String sqlType2JavaType(String sqlType) {

        if (sqlType.equalsIgnoreCase("bit")) {
            return Boolean.class.getSimpleName();
        } else if (sqlType.equalsIgnoreCase("tinyint")) {
            return Integer.class.getSimpleName();
        } else if (sqlType.equalsIgnoreCase("smallint")) {
            return "short";
        } else if (sqlType.equalsIgnoreCase("int")) {
            return Integer.class.getSimpleName();
        } else if (sqlType.equalsIgnoreCase("bigint")) {
            return Long.class.getSimpleName();
        } else if (sqlType.equalsIgnoreCase("float")) {
            return "float";
        } else if (sqlType.equalsIgnoreCase("timestamp")) {
            return LocalDateTime.class.getSimpleName();
        } else if (sqlType.equalsIgnoreCase("decimal") || sqlType.equalsIgnoreCase("numeric")
                || sqlType.equalsIgnoreCase("real") || sqlType.equalsIgnoreCase("money")
                || sqlType.equalsIgnoreCase("smallmoney")) {
            return BigDecimal.class.getSimpleName();
        } else if (sqlType.equalsIgnoreCase("varchar") || sqlType.equalsIgnoreCase("char")
                || sqlType.equalsIgnoreCase("nvarchar") || sqlType.equalsIgnoreCase("nchar")
                || sqlType.equalsIgnoreCase("text")) {
            return "String";
        } else if (sqlType.equalsIgnoreCase("datetime") || sqlType.equalsIgnoreCase("date")) {
            return "Date";
        } else if (sqlType.equalsIgnoreCase("image")) {
            return "Blod";
        }

        return null;
    }

    /*
     * 获取整个类的字符串并且输出为java文件
     */
    public StringBuffer getClassStr() {
        // 输出的类字符串
        StringBuffer str = new StringBuffer("");
        // 获取表类型和表名的字段名
        this.doAction();
        // 校验
        if (null == colnames && null == colTypes)
            return null;
        // 拼接

        str.append("@Entity").append(LF);
        str.append("@Setter @Getter").append(LF);
        str.append("@Table(name =\"" + table + "\")").append(LF);

        str.append("public class " + transferTableName() + " extends AbstractEntity<Long> " + " { " + "\n\r");
        // 拼接属性
        for (int index = 0; index < colnames.size(); index++) {
            str.append(getAttrbuteString(colnames.get(index), colTypes.get(index)));
        }
        // 拼接get，Set方法
        // for(int index=1; index < colnames.length ; index++){
        // str.append(getGetMethodString(colnames[index],colTypes[index]));
        // str.append(getSetMethodString(colnames[index],colTypes[index]));
        // }
        str.append("}\r\n");
        // 输出到文件中
        // File file = new File(table+".java");
        // BufferedWriter write = null;
        //
        // try {
        // write = new BufferedWriter(new FileWriter(file));
        // write.write(str.toString());
        // write.close();
        // } catch (IOException e) {
        //
        // e.printStackTrace();
        // if (write != null)
        // try {
        // write.close();
        // } catch (IOException e1) {
        // e1.printStackTrace();
        // }
        // }
        return str;
    }

    public StringBuffer getAngularClassStr() {
        StringBuffer str = new StringBuffer("");

        str.append("export class ").append(transferTableName()).append(" {").append(LF);


        str.append(PADDING).append(PADDING).append("id: string;  ").append(LF);
        for (int index = 0; index < colnames.size(); index++) {
            str.append(getAngularAttrbuteString(colnames.get(index), colTypes.get(index)));
        }

        str.append("} ");

        return str;
    }

    private StringBuffer getAngularAttrbuteString(String name, String type) {
        StringBuffer str = new StringBuffer("");

        str.append(PADDING).append(PADDING).append(translate(name)).append(": ").append(transToTypeScript(translate(type))).append(";").append(LF);

        return str;
    }

    private String transToTypeScript(String javaType) {

        if (javaType.equals(Boolean.class.getSimpleName())) {
            return "boolean";
        }

        if (javaType.equals(Integer.class.getSimpleName()) || javaType.equals(Long.class.getSimpleName())) {
            return "number";
        }

        if (javaType.equals(String.class.getSimpleName())) {
            return "string";
        }

        return "null";
    }

    private String transferTableName() {

        String classname = translate(table.replace("zb_", "").replace("bss_", ""));

        char[] arr = classname.toCharArray();
        if (arr.length != 0) {
            if (Character.isLowerCase(arr[0])) {
                char upper = Character.toUpperCase(arr[0]);
                arr[0] = upper;
            }
        }
        String className = new StringBuilder().append(arr).toString();

        return className.endsWith("s") ? className.substring(0, className.length() - 1) : className;
    }

    /*
     * 获取字段字符串
     */
    public StringBuffer getAttrbuteString(String name, String type) {
        if (!check(name, type)) {
            System.out.println("类中有属性或者类型为空");
            return null;
        }
        ;
        String format = String.format("    private %s %s;\n\r", type, translate(name));
        return new StringBuffer(format);
    }

    private String translate(String string) {

        int length = string.length();
        if (length == 0)
            return "";
        StringBuilder buf = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char character = string.charAt(i);

            if ('_' == character) {
                buf.append(Character.toUpperCase(string.charAt(++i)));
            } else {
                buf.append(character);
            }

        }

        return buf.toString();
    }

    /*
     * 校验name和type是否合法
     */
    public boolean check(String name, String type) {
        if ("".equals(name) || name == null || name.trim().length() == 0) {
            return false;
        }
        if ("".equals(type) || type == null || type.trim().length() == 0) {
            return false;
        }
        return true;

    }

    /*
     * 获取get方法字符串
     */
    @SuppressWarnings("unused")
    private StringBuffer getGetMethodString(String name, String type) {
        if (!check(name, type)) {
            System.out.println("类中有属性或者类型为空");
            return null;
        }
        ;
        String Methodname = "get" + GetTuoFeng(name);
        String format = String.format("    public %s %s(){\n\r", new Object[]{type, Methodname});
        format += String.format("        return this.%s;\r\n", new Object[]{name});
        format += "    }\r\n";
        return new StringBuffer(format);
    }

    // 将名称首字符大写
    private String GetTuoFeng(String name) {
        name = name.trim();
        if (name.length() > 1) {
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
        } else {
            name = name.toUpperCase();
        }
        return name;
    }

    /*
     * 获取字段的get方法字符串
     */
    @SuppressWarnings("unused")
    private Object getSetMethodString(String name, String type) {
        if (!check(name, type)) {
            System.out.println("类中有属性或者类型为空");
            return null;
        }
        ;
        String Methodname = "set" + GetTuoFeng(name);
        String format = String.format("    public void %s(%s %s){\n\r", new Object[]{Methodname, type, name});
        format += String.format("        this.%s = %s;\r\n", new Object[]{name, name});
        format += "    }\r\n";
        return new StringBuffer(format);
    }

    public static void main(String[] args) {
        ReflectBean bean = new ReflectBean();
        System.out.println(bean.getClassStr());
        System.out.println(bean.getAngularClassStr());
    }

}
