package ru.lvl20.lecture03.task2;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
Читаем и пишем в файл: JavaRush
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        private List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) {
            //implement this method - реализуйте этот метод
            try (PrintWriter printWriter = new PrintWriter(outputStream)) {
                for (User user : users) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(user.getFirstName()).append(";");
                    sb.append(user.getLastName()).append(";");
                    sb.append(user.getBirthDate().getTime()).append(";");
                    sb.append(user.isMale()).append(";");
                    sb.append(user.getCountry());

                    printWriter.println(sb);
                }
            }
        }

        public void load(InputStream inputStream) throws IOException {
            //implement this method - реализуйте этот метод
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String[] values;
                String line;
                while (reader.ready()) {
                    line = reader.readLine();
                    values = line.split(";");
                    if (values.length < 5)
                        break;

                    User user = new User();
                    user.setFirstName(values[0]);
                    user.setLastName(values[1]);
                    user.setBirthDate(new Date(Long.parseLong(values[2])));
                    user.setMale(Boolean.parseBoolean(values[3]));

                    switch (values[4]) {
                        case "UKRAINE":
                            user.setCountry(User.Country.UKRAINE);
                            break;
                        case "RUSSIA":
                            user.setCountry(User.Country.RUSSIA);
                            break;
                        default:
                            user.setCountry(User.Country.OTHER);

                    }
                    users.add(user);
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}


