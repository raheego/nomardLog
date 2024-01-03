package bbs;


//import javax.sql.DataSource;

//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@SpringBootApplication
@MapperScan("bbs.mapper") // 부트에서는 @MapperScan을 이용해서 sqlSession 생성 안해도 됨!
public class BbsApplication { 

	public static void main(String[] args) { 
		SpringApplication.run(BbsApplication.class, args);

	}
	
}
	
//	@Bean
//	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception  {
//		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//		sessionFactory.setDataSource(dataSource);
//		
//		Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mapper/**/*.xml");
//		sessionFactory.setMapperLocations(res);
//		
//		return sessionFactory.getObject();
//		
//	}
//
//}
