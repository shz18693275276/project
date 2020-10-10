package com.ruoyi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动程序
 * 
 * @author ruoyi
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class CollegeApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(CollegeApplication.class, args);














        System.out.println("(♥◠‿◠)ﾉﾞ  天水高等院校项目管理系统启动动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                " .============.                   =====       \n" +
                "       ||  _ _             _ _   //    \\\\      \n" +
                "       || ( ' )  |       |  ( ' )||    oo    \n" +
                "       ||(_ o _) /       \\ (_ o _)\\\\        \n" +
                "       || (_._).'          '.(_._)   ====      \n" +
                "       ||        \\       /               ||    \n" +
                "       ||          o    o               //     \n" +
                "       ||           \\/\\/        \\\\    //       \n" +
                "                 ''-'   `'-'      ====    ");
    }
}
