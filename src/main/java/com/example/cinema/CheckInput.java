package com.example.cinema;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CheckInput {
    public static String check(String regex, String word, String masError){
        if (!word.matches(regex))
            return masError;
        else
            return "ok";
    }

    public static String CheckUser(User user){
        BaseUsers baseuser = GetBase();

        if (baseuser == null)
            return "Неправильный логин или пароль";

        if (!baseuser.Base.containsKey(user.email))
            return "Неправильный логин или пароль";

        User CurUser = baseuser.Base.get(user.email);
        if (!CurUser.password.equals(user.password))
            return "Неправильный логин или пароль";

        return "ok";
    }
    public static String SetInBase(User user) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

       BaseUsers baseUsers = GetBase();

        if (baseUsers != null) {
            if (baseUsers.Base.containsKey(user.email))
                return "Пользователь с такой почтой уже существует";
        }
        else
            baseUsers = new BaseUsers();
        user.role = "user";
        user.nameOfPicture = "";
        baseUsers.Base.put(user.email, user);

        String StringBase = mapper.writeValueAsString(baseUsers);

        try{
            FileOutputStream fileOutputStream = new FileOutputStream(
                    new File("D:\\apache-tomcat-8.5.84\\webapps\\Cinema\\src\\main\\webapp\\Bases\\Users.txt"), false);
            fileOutputStream.write(StringBase.getBytes());
            fileOutputStream.close();
            System.out.println("Успешно");
            return "ok";
        }
        catch (Exception e)
        {
            System.out.println("Ошибка записи");
            return "Какие-то ошибки";
        }
    }

    public static String UpdateUser(User user) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        BaseUsers baseUsers = GetBase();

        baseUsers.Base.put(user.email, user);

        String StringBase = mapper.writeValueAsString(baseUsers);

        try{
            FileOutputStream fileOutputStream = new FileOutputStream(
                    new File("D:\\apache-tomcat-8.5.84\\webapps\\Cinema\\src\\main\\webapp\\Bases\\Users.txt"),false);
            fileOutputStream.write(StringBase.getBytes());
            fileOutputStream.close();
            System.out.println("Успешно");
            return "ok";
        }
        catch (Exception e)
        {
            System.out.println("Ошибка записи");
            return "Какие-то ошибки";
        }
    }

    public static BaseUsers GetBase(){
        ObjectMapper mapper = new ObjectMapper();
        try{

            File file = new File("D:\\apache-tomcat-8.5.84\\webapps\\Cinema\\src\\main\\webapp\\Bases\\Users.txt");
            byte[] bytes = new byte[(int) file.length()];
            FileInputStream fileInputStream =
                    new FileInputStream(file);
            fileInputStream.read(bytes);

            String fileContent = new String(bytes, "windows-1251");
            System.out.println(fileContent);

            fileInputStream.close();
            return mapper.readValue(fileContent, BaseUsers.class);


        }
        catch (Exception e)
        {
            System.out.println("Ошибка чтения");
            return null;
        }
    }

    public static void SetNumberOfVisit(int number) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        NumberOfVisit num = new NumberOfVisit();
        num.count = number;
        String StringBase = mapper.writeValueAsString(num);
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(
                    new File("D:\\apache-tomcat-8.5.84\\webapps\\Cinema\\src\\main\\webapp\\Bases\\numberOfVisit.txt"),false);
            fileOutputStream.write(StringBase.getBytes());
            fileOutputStream.close();
            System.out.println("Успешно");
        }
        catch (Exception e)
        {
            System.out.println("Ошибка записи");
        }
    }

    public static NumberOfVisit GetNumber(){
        ObjectMapper mapper = new ObjectMapper();
        try{
            FileInputStream fileInputStream =
                    new FileInputStream(
                            new File("D:\\apache-tomcat-8.5.84\\webapps\\Cinema\\src\\main\\webapp\\Bases\\numberOfVisit.txt"));
            int index;
            String base = "";
            while ((index = fileInputStream.read())!=-1){
                base += (char)index;
            }
            fileInputStream.close();
            return mapper.readValue(base, NumberOfVisit.class);
        }
        catch (Exception e)
        {
            System.out.println("Ошибка чтения");
            return null;
        }
    }

    public static BaseNews GetBaseNews(){
        ObjectMapper mapper = new ObjectMapper();
        try{
            File file = new File("D:\\apache-tomcat-8.5.84\\webapps\\Cinema\\src\\main\\webapp\\Bases\\News.txt");
            byte[] bytes = new byte[(int) file.length()];
            FileInputStream fileInputStream =
                    new FileInputStream(file);
            fileInputStream.read(bytes);

            String fileContent = new String(bytes, "windows-1251");
            System.out.println(fileContent);

            fileInputStream.close();
            if (fileContent.equals(""))
                return new BaseNews();
            else    return mapper.readValue(fileContent, BaseNews.class);
        }
        catch (Exception e)
        {
            System.out.println("Ошибка чтения");
            return null;
        }
    }

    public static void SetNewInBase(News news) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        BaseNews baseNews = GetBaseNews();

        baseNews.Base.add(news);

        String StringBase = mapper.writeValueAsString(baseNews);

        try{
            FileOutputStream fileOutputStream = new FileOutputStream(
                    new File("D:\\apache-tomcat-8.5.84\\webapps\\Cinema\\src\\main\\webapp\\Bases\\News.txt"), false);
            fileOutputStream.write(StringBase.getBytes());
            fileOutputStream.close();
            System.out.println("Успешно");
        }
        catch (Exception e)
        {
            System.out.println("Ошибка записи");
        }
    }

    public static void UpdateNew(int number, News news) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        BaseNews baseNews = GetBaseNews();

        baseNews.Base.set(number, news);

        String StringBase = mapper.writeValueAsString(baseNews);

        try{
            FileOutputStream fileOutputStream = new FileOutputStream(
                    new File("D:\\apache-tomcat-8.5.84\\webapps\\Cinema\\src\\main\\webapp\\Bases\\News.txt"), false);
            fileOutputStream.write(StringBase.getBytes());
            fileOutputStream.close();
            System.out.println("Успешно");
        }
        catch (Exception e)
        {
            System.out.println("Ошибка записи");
        }
    }



    public static void copyFile(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }
}
