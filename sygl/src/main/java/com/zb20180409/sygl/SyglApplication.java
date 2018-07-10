package com.zb20180409.sygl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zb20180409.sygl.dao")//找到dao的接口 并帮助其完成实现类
public class SyglApplication {

	public static void main(String[] args) {
		SpringApplication.run(SyglApplication.class, args);
	}
}
