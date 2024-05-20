package sreeni.digitallibrary.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfiguration {

  @Bean
  public LettuceConnectionFactory getLettuceConnectionFactory(){
    RedisStandaloneConfiguration redisStandaloneConfiguration=new RedisStandaloneConfiguration("redis-15150.c212.ap-south-1-1.ec2.redns.redis-cloud.com", 15150);
    redisStandaloneConfiguration.setPassword("SXepHw51M6OLXw5qfW7xpJxpmYuDjMiU");
    LettuceConnectionFactory lettuceConnectionFactory=new LettuceConnectionFactory(redisStandaloneConfiguration);
    return lettuceConnectionFactory;
  }

  @Bean
  public RedisTemplate<String,Object> getRedisTemplate(LettuceConnectionFactory lettuceConnectionFactory){
    RedisTemplate<String,Object> redisTemplate=new RedisTemplate<>();
    redisTemplate.setKeySerializer(new StringRedisSerializer());
    redisTemplate.setHashKeySerializer(new StringRedisSerializer());
    redisTemplate.setValueSerializer(new StringRedisSerializer());
    redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
    redisTemplate.setConnectionFactory(lettuceConnectionFactory);
    return redisTemplate;
  }
}
