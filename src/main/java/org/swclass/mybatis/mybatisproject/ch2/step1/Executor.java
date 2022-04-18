package org.swclass.mybatis.mybatisproject.ch2.step1;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.swclass.mybatis.mybatisproject.Shop;

import java.io.IOException;
import java.io.Reader;

public class Executor {
    private static SqlSessionFactory sqlSessionFactory;
    private static final Log log = LogFactory.getLog(Executor.class);

    static {
        try {
            String resource = "mybatis/config-mybatis.xml";
            Reader reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            Shop shop = new Shop();
            shop.setShopNo(4);

            sqlSession.delete("org.mybatis.persistence.ShopMapper.delete", shop);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();

            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }

    }
}
