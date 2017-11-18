package starter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.*;

@SpringBootApplication
public class RedisSpringBootApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void run(String... args) throws Exception {

        HashOperations hashOperations = redisTemplate.opsForHash();
        ListOperations listOperations = redisTemplate.opsForList();
        SetOperations setOperations = redisTemplate.opsForSet();

        //Test data
        setOperations.add("N", "Nasir", "Nasruddin");
        setOperations.add("A", "Asmit", "Abhijeet");

        //Fetch values from set
        logger.info("Value for Key N in set Operation :: {}", setOperations.members("N"));
        logger.info("Value for Key A in set Operation :: {}", setOperations.members("A"));

        //Using Hash Operation
        String zahir = "Zahir";
        hashOperations.put("Z", String.valueOf(zahir.hashCode()), zahir);
        logger.info("Value for R in Hash Operations :: {}",
                hashOperations.get("Z", String.valueOf(zahir.hashCode())));
    }



    public static void main(String[] args) {
        SpringApplication.run(RedisSpringBootApplication.class, args);
    }

}
