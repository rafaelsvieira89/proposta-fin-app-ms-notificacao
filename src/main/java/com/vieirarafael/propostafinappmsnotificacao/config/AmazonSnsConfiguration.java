package com.vieirarafael.propostafinappmsnotificacao.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonSnsConfiguration {
    @Value( "${amazon.sns.access-key}")
    private String accessKey;
    @Value( "${amazon.sns.secret-key}")
    private String secretKey;
    @Bean
    public AWSCredentials getAWSCredentials() {
        return new BasicAWSCredentials(accessKey, secretKey);
    }
    public AmazonSNS amazonSNS(){
        return AmazonSNSClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(getAWSCredentials()))
                .withRegion(Regions.US_EAST_1)
                .build();
    }
}
