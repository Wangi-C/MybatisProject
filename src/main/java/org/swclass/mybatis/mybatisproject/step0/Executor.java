package org.swclass.mybatis.mybatisproject.step0;

import java.util.ArrayList;
import java.util.List;

public class Executor {
    public static void main(String[] args) {
        try {
            List<Object> parameters = new ArrayList<Object>();
            parameters.add(1);
            parameters.add("Y");

            Application application = new Application();
            Shop shop = application.view(parameters);

            System.out.println(shop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
